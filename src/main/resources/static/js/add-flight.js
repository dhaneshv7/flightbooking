document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('add-flight-form');
    const message = document.getElementById('message');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();

        // Collect form data into a JavaScript object
        const flightData = {
            flightNumber: document.getElementById('flightNumber').value,
            origin: document.getElementById('origin').value,
            destination: document.getElementById('destination').value,
            departureTime: document.getElementById('departureTime').value,
            arrivalTime: document.getElementById('arrivalTime').value,
            price: parseFloat(document.getElementById('price').value),
            totalSeats: parseInt(document.getElementById('totalSeats').value),
            flightClass: document.getElementById('flightClass').value,
            type: document.getElementById('flightType').value,
        };

        try {
            // Send a POST request to the backend API
            const response = await fetch('/api/flights/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(flightData),
            });

            if (response.ok) {
                // Handle successful response
                message.textContent = 'Flight added successfully!';
                message.style.color = 'green';
                form.reset(); // Clear the form fields
            } else {
                // Handle error response from the server
                const error = await response.json();
                message.textContent = `Error: ${error.message}`;
                message.style.color = 'red';
            }
        } catch (error) {
            // Handle network or other unexpected errors
            message.textContent = 'An unexpected error occurred.';
            message.style.color = 'red';
            console.error('Error:', error);
        }
    });
});