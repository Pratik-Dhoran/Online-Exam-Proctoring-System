let attemptId = localStorage.getItem("attemptId");
console.log("Loaded attemptId:", attemptId);

if (!attemptId) {
    alert("Attempt ID missing — please start exam again!");
    window.location.href = "exam.html";
}

function enterFullscreen() {
    let elem = document.documentElement;

    if (elem.requestFullscreen) {
        elem.requestFullscreen();
    }

    document.getElementById("fullscreen-overlay").style.display = "none";

    loadExamPaper();
    startTimer(30);
}


function loadExamPaper() {

    let examId = localStorage.getItem("examId");

    if (!examId) {
        alert("Exam ID missing — please start exam again!");
        window.location.href = "exam.html";
        return;
    }

    fetch(`/api/exams/${examId}/paper`)
        .then(res => {
            if (!res.ok) throw new Error("Failed to load exam paper: " + res.status);
            return res.json();
        })
        .then(data => {
            document.getElementById("exam-title").innerText = data.title;

            let area = document.getElementById("question-area");
            area.innerHTML = "";

            data.questions.forEach((q, index) => {
                let div = document.createElement("div");
                div.className = "question-card";

                let html = `
                    <p class="question-text"><b>Q${index + 1}:</b> ${q.text}</p>
                    <div class="options-box">
                `;

                q.options.forEach(opt => {
                    html += `
                        <label class="option-item">
                            <input type="radio"
                                   name="q${q.questionId}"
                                   value="${opt.optionId}"
                                   onclick="saveAnswer(${q.questionId}, ${opt.optionId})">
                            ${opt.text}
                        </label>
                    `;
                });

                html += "</div>";
                div.innerHTML = html;
                area.appendChild(div);
            });
        })
        .catch(err => {
            alert(err.message);
            console.error(err);
        });
}

// Save answer to backend
function saveAnswer(questionId, optionId) {
    let attemptId = localStorage.getItem("attemptId");
    if (!attemptId) {
        alert("Attempt ID missing — cannot save answer!");
        return;
    }

    fetch(`/api/answers/submit?attemptId=${attemptId}&questionId=${questionId}&optionId=${optionId}`, {
        method: "POST"
    })
        .then(res => {
            if (!res.ok) throw new Error("Answer submission failed: " + res.status);
            console.log("Answer saved");
        })
        .catch(err => console.log(err.message));
}

// Timer
function startTimer(minutes) {
    let seconds = minutes * 60;

    let timer = setInterval(() => {
        let min = Math.floor(seconds / 60);
        let sec = seconds % 60;

        document.getElementById("timer").innerText =
            `Time Left: ${min}:${sec < 10 ? "0" + sec : sec}`;

        seconds--;

        if (seconds < 0) {
            clearInterval(timer);
            submitExam();
        }
    }, 1000);
}

// Submit exam
function submitExam() {
    let attemptId = localStorage.getItem("attemptId");
    if (!attemptId) {
        alert("Attempt ID missing — cannot submit exam!");
        window.location.href = "exam.html";
        return;
    }
    // Result page will read attemptId from localStorage
    window.location.href = "result.html";
}
