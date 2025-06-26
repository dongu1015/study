document.addEventListener("DOMContentLoaded", () => {
    const loginBtn = document.getElementById("login-button");
    if (loginBtn) {
        loginBtn.addEventListener("click", login);
    }

    const signupBtn = document.querySelector("button[onclick='signup()']");
    if (signupBtn) {
        signupBtn.addEventListener("click", signup);
    }

    // particles 직접 설정 (JSON 파일 없이)
    if (window.particlesJS) {
        particlesJS('particles-js', {
            particles: {
                number: { value: 60 },
                size: { value: 3 },
                move: { speed: 1 },
                line_linked: { enable: true, distance: 150 },
                color: { value: "#ffffff" }
            },
            interactivity: {
                events: {
                    onhover: { enable: true, mode: "repulse" }
                }
            }
        });
    }
});

function login() {
    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();

    if (!username || !password) {
        alert("아이디와 비밀번호를 입력해주세요.");
        return;
    }

    fetch("/api/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    })
        .then(response => {
            console.log("응답 상태:", response.status);
            if (!response.ok) throw new Error("로그인 실패");
            return response.json();
        })
        .then(data => {
            console.log("서버 응답 데이터:", data);
            alert("로그인 성공");
            window.location.href = "/home";
        })
        .catch(error => {
            console.error("에러:", error);
            alert("로그인에 실패했습니다.");
        });
}

function signup() {
    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();
    const email = document.getElementById("email").value.trim();

    if (!username || !password || !email) {
        alert("모든 항목을 입력해주세요.");
        return;
    }

    fetch("/api/signup", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password, email })
    })
        .then(response => {
            if (!response.ok) throw new Error("회원가입 실패");
            return response.json();
        })
        .then(data => {
            alert("회원가입 성공! 로그인 페이지로 이동합니다.");
            window.location.href = "/login";
        })
        .catch(error => {
            console.error("에러:", error);
            alert("회원가입에 실패했습니다.");
        });
}
