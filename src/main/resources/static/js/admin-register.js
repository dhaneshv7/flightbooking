document.addEventListener('DOMContentLoaded', () => {
    const registerForm = document.getElementById('admin-register-form');
    const registerMessage = document.getElementById('register-message');

    registerForm.addEventListener('submit', async (e) => {
        e.preventDefault();

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        try {
            const response = await fetch('/api/admin/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password }),
            });

            const message = await response.text();

            if (response.ok) {
                registerMessage.style.color = 'green';
                registerMessage.textContent = 'Registration successful! You can now log in.';
            } else {
                registerMessage.style.color = 'red';
                registerMessage.textContent = message;
            }
        } catch (error) {
            registerMessage.style.color = 'red';
            registerMessage.textContent = 'An unexpected error occurred.';
            console.error('Error:', error);
        }
    });
});