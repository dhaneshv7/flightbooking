✈️ FlyEase: Online Flight Booking System
FlyEase is a full-stack web application designed to help customers book flight tickets online, check seat availability, and manage flight details for both national and international routes.

✨ Features
Flight Search: Search for flights instantly between a pickup location and a destination.

Real-time Data: Consolidates flight details, timing, and available seats from all integrated airlines.

Admin Management: Dedicated portal for administrators to log in, register, and add new flight records.

Booking System: Allows users to select a class, choose a time slot, and complete payment to book tickets.

Seat Availability: Real-time seat tracking integrated into the booking process.

Clean UI/UX: A responsive and modern interface with CSS animations for an engaging user experience.

🛠️ Technology Stack
Component	Technology	Version / Framework	Purpose
Backend	Java	25+	Core application logic and REST API.
Framework	Spring Boot	3.x	Rapid application development and Dependency Injection.
Database	MySQL	Latest	Persistent storage for flights, bookings, and users.
ORM	Spring Data JPA	-	Object-Relational Mapping for database interaction.
Frontend	HTML5, CSS3, JavaScript	-	User interface, styling, and client-side interactivity.
Build Tool	Maven	-	Project build and dependency management.

Export to Sheets
🚀 Setup and Run Instructions
1. Prerequisites
Java Development Kit (JDK): Version 21 or higher (as you mentioned 25+).

MySQL Server: Running on your local machine (default port 3306).

IntelliJ IDEA: (Recommended IDE for Java/Spring Boot development).

2. Database Configuration
Create a new schema in MySQL named flight_booking_db.

Update the connection details in src/main/resources/application.properties:

Properties

spring.datasource.url=jdbc:mysql://localhost:3306/flight_booking_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update # Creates tables automatically
3. Run the Backend
Open the project in IntelliJ IDEA.

Locate the main class: src/main/java/com/example/flightbooking/FlightBookingApplication.java.

Right-click and select Run 'FlightBookingApplication'.

The application will start on http://localhost:8080 (or the port specified in application.properties).

4. Access the Interface
The application serves both the API endpoints and the static frontend files.

Customer Portal: Access the main flight search page at: http://localhost:8080/index.html

Admin Portal: Access the admin login/registration page via the link on the homepage or directly at: http://localhost:8080/admin-login.html

📂 Project Structure Overview
The project follows a standard Spring Boot and Model-View-Controller (MVC) structure.

flight-booking-app/
├── src/main/java/com/example/flightbooking/
│   ├── controller/      # REST API endpoints (Flight, Booking, Admin, Customer)
│   ├── model/           # JPA Entities (Flight, Booking, Admin, Customer)
│   ├── repository/      # Spring Data JPA interfaces for database access
│   └── service/         # Business logic layer (validation, transaction management)
├── src/main/resources/
│   ├── application.properties # Configuration (DB, port, etc.)
│   └── static/          # Frontend assets (HTML, CSS, JS, Images)
└── pom.xml              # Project dependencies and build configuration
Key Frontend Files
File	Purpose
index.html	Main search and results page.
admin-dashboard.html	Form for administrators to add new flights.
style.css	All styling, including the new button animation and background.
script.js	JavaScript for general flight search functionality.
add-flight.js	JavaScript for handling the Admin Dashboard's form submission.

Export to Sheets
📝 Future Enhancements
Integration with Spring Security for secure password hashing (BCrypt) and JWT-based authentication.

Real-time payment gateway integration (e.g., Stripe or PayPal).

User account management and viewing of past bookings.

Advanced filtering options for flight searches (price range, class, airline).
