document.addEventListener('DOMContentLoaded', () => {
    const searchForm = document.getElementById('search-form');
    const flightResults = document.getElementById('flight-results');

    searchForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const origin = document.getElementById('origin').value;
        const destination = document.getElementById('destination').value;

        try {
            const response = await fetch(`/api/flights/search?origin=${origin}&destination=${destination}`);
            const flights = await response.json();

            displayFlights(flights);
        } catch (error) {
            console.error('Error fetching flights:', error);
            flightResults.innerHTML = '<p>Something went wrong. Please try again later.</p>';
        }
    });

    function displayFlights(flights) {
        flightResults.innerHTML = '';
        if (flights.length === 0) {
            flightResults.innerHTML = '<p>No flights found for this route.</p>';
            return;
        }

        flights.forEach(flight => {
            const card = document.createElement('div');
            card.className = 'flight-card';
            card.innerHTML = `
                <div>
                    <h3>${flight.flightNumber}</h3>
                    <p><strong>${flight.origin}</strong> to <strong>${flight.destination}</strong></p>
                    <p>Departure: ${new Date(flight.departureTime).toLocaleString()}</p>
                    <p>Arrival: ${new Date(flight.arrivalTime).toLocaleString()}</p>
                    <p>Class: ${flight.flightClass}</p>
                </div>
                <div class="price-section">
                    <p class="price">$${flight.price}</p>
                    <p>${flight.availableSeats} seats left</p>
                    <button class="book-btn">Book Now</button>
                </div>
            `;
            flightResults.appendChild(card);
        });
    }
});