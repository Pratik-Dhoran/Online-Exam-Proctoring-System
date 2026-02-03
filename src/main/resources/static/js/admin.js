let role = localStorage.getItem("userRole");

if (role !== "ADMIN") {
    alert("Access denied");
    window.location.href = "index.html";
}

window.onload = function() {
    loadAllExams();
};

function createExam() {

    let title = document.getElementById("title").value;
    let description = document.getElementById("description").value;
    let duration = document.getElementById("duration").value;

    fetch("/api/exams", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            title: title,
            description: description,
            durationMinutes: duration
        })
    })
    .then(res => res.json())
    .then(data => {
        alert("Exam created successfully!");
        loadAllExams();
    })
    .catch(err => alert("Failed to create exam"));
}

function loadAllExams() {

    fetch("/api/exams")
        .then(res => res.json())
        .then(data => {

            let list = document.getElementById("admin-exam-list");
            list.innerHTML = "";

            data.forEach(exam => {

                let div = document.createElement("div");
                div.className = "exam-card";

                div.innerHTML = `
                    <h3>${exam.title}</h3>
                    <p><b>Exam ID:</b> ${exam.id}</p>
                    <p>${exam.description}</p>
                    <p>Duration: ${exam.durationMinutes} minutes</p>
                `;

                list.appendChild(div);
            });
        });
}

function viewExam(examId) {
    window.location.href = "exam-paper.html";
}

function logout() {
    localStorage.clear();
    window.location.href = "login.html";
}

function addQuestion() {

    let examId = document.getElementById("q-exam-id").value;
    let text = document.getElementById("q-text").value;
    let optionsText = document.getElementById("q-options").value;
    let correctIndex = document.getElementById("q-correct").value;

    let options = optionsText.split(",");

    let requestBody = {
        text: text,
        options: options,
        correctOptionIndex: parseInt(correctIndex)
    };

    fetch(`/api/exams/${examId}/questions`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(requestBody)
    })
    .then(res => res.json())
    .then(data => {
        alert("Question added successfully!");
    })
    .catch(err => alert("Failed to add question"));
}
