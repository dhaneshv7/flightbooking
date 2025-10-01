document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('admin-login-form');
    const loginMessage = document.getElementById('login-message');

    loginForm.addEventListener('submit', async (e) => {
        e.preventDefault();

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        try {
            const response = await fetch('/api/admin/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password }),
            });

            const message = await response.text();

            if (response.ok) {
                loginMessage.style.color = 'green';
                loginMessage.textContent = 'Login successful! Redirecting...';
                // In a real application, you would handle a token here and redirect
                window.location.href = '/admin-dashboard.html';
            } else {
                loginMessage.style.color = 'red';
                loginMessage.textContent = message;
            }
        } catch (error) {
            loginMessage.style.color = 'red';
            loginMessage.textContent = 'An unexpected error occurred.';
            console.error('Error:', error);
        }
    });
});