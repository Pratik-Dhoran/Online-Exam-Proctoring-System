function register() {

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    fetch("/api/users/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            name: name,
            email: email,
            password: password,
            role: "STUDENT"
        })
    })
    .then(res => {
        if (!res.ok) {
            throw new Error("Registration failed");
        }
        return res.json();
    })
    .then(data => {
        alert("Registration successful");
        window.location.href = "login.html";
    })
    .catch(err => alert("Registration failed"));
}


function login() {

    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    fetch("/api/users/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            email: email,
            password: password
        })
    })
    .then(res => {
        if (!res.ok) {
            throw new Error("Login failed");
        }
        return res.json();
    })
    .then(data => {
        localStorage.setItem("token", data.token);
        localStorage.setItem("userEmail", email);
        localStorage.setItem("userRole", data.role);

        if (data.role === "ADMIN") {
            window.location.href = "admin.html";
        } else {
            window.location.href = "exam.html";
        }
    })
    .catch(err => alert("Invalid email or password"));
}
