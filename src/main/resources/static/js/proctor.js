document.addEventListener("visibilitychange", function() {

    let attemptId = localStorage.getItem("attemptId");

    if (!attemptId) return;

    if (document.hidden) {

        fetch(`/api/proctor/log?attemptId=${attemptId}&eventType=TAB_SWITCH&details=User switched tab`, {
            method: "POST"
        });
    }
});

document.addEventListener("fullscreenchange", function() {

    let attemptId = localStorage.getItem("attemptId");

    if (!attemptId) return;

    if (!document.fullscreenElement) {

        fetch(`/api/proctor/log?attemptId=${attemptId}&eventType=FULLSCREEN_EXIT&details=User exited fullscreen`, {
            method: "POST"
        });
    }
});
