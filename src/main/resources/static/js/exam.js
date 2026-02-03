// Load exams on page load
window.onload = function () {
    loadExams();
};

// Fetch all exams and render
function loadExams() {
    fetch("/api/exams")
        .then(res => {
            if (!res.ok) throw new Error("Failed to load exams: " + res.status);
            return res.json();
        })
        .then(data => {
            let examList = document.getElementById("exam-list");
            examList.innerHTML = "";

            data.forEach(exam => {
                let card = document.createElement("div");
                card.className = "exam-card";

                card.innerHTML = `
                    <h3>${exam.title}</h3>
                    <p>${exam.description}</p>
                    <p>Duration: ${exam.durationMinutes} minutes</p>
                    <button onclick="startExam(${exam.id})">Start Exam</button>
                `;

                examList.appendChild(card);
            });
        })
        .catch(err => {
            alert(err.message);
            console.error(err);
        });
}

// Start exam, get attemptId, save to localStorage
function startExam(examId) {

    let email = localStorage.getItem("userEmail");

    if (!email) {
        alert("Please login again!");
        window.location.href = "login.html";
        return;
    }

    fetch(`/api/attempts/start/${examId}?email=${email}`, {
        method: "POST"
    })
    .then(res => {
        if (!res.ok) throw new Error("Failed to start exam: " + res.status);
        return res.json();
    })
    .then(data => {
        localStorage.setItem("attemptId", data.id);
        window.location.href = "exam-paper.html";
    })
    .catch(err => {
        alert(err.message);
        console.error(err);
    });
}


// Logout user
function logout() {
    localStorage.clear();
    window.location.href = "index.html";
}

// Razorpay enrollment (optional, test mode)
function enrollCourse(courseId) {

    let amount = courseId === 1 ? 99900 :
                 courseId === 2 ? 79900 : 129900;

    fetch("/api/payments/create-order", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ amount: amount })
    })
    .then(res => res.json())
    .then(order => {

        var options = {
            "key": "rzp_test_SBYPI5bpzVBkkN",
            "amount": order.amount,
            "currency": "INR",
            "name": "TechEval Platform",
            "description": "Course Enrollment",
            "order_id": order.id,
            "handler": function () {

                alert("Enrolled successfully 🎉");

                window.location.href = "exam.html";
            }
        };

        var rzp = new Razorpay(options);
        rzp.open();

    })
    .catch(err => {
        alert("Payment failed");
        console.error(err);
    });
}


function verifyPayment(paymentId, orderId, signature) {
    fetch("/api/payments/verify", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ paymentId, orderId, signature })
    })
    .then(res => res.json())
    .then(() => window.location.href = "enrolled.html")
    .catch(err => alert("Payment verification failed"));
}
