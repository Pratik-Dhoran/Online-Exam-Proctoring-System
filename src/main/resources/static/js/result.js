window.onload = function () {

    let attemptId = localStorage.getItem("attemptId");

    if (!attemptId) {
        alert("No attempt found");
        window.location.href = "exam.html";
        return;
    }

    fetch(`/api/results/${attemptId}`)
        .then(res => res.json())
        .then(data => {

            document.getElementById("score").innerText =
                data.score + " / " + data.total;

            if (data.status === "PASS") {
                document.getElementById("status").innerHTML =
                    "PASS";
            } else {
                document.getElementById("status").innerHTML =
                    "FAIL";
            }

            document.getElementById("risk").innerText = data.riskScore;

            document.getElementById("feedback").innerText =
                data.feedback;
        });
};

function goHome() {
    localStorage.removeItem("attemptId");
    window.location.href = "exam.html";
}
