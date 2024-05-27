# Employee Management System Webapp

This project is a full-stack web application for managing employee data, built using Spring Boot for the backend, React for the frontend, and MySQL for the database.

## Tech Stack

- **Backend:** Spring Boot, Java
- **Frontend:** React, HTML, CSS
- **Database:** MySQL

## Features

- **RESTful APIs:** Developed with Spring Boot to perform CRUD operations for managing employee data efficiently.
- **Responsive Frontend:** Integrated with React to ensure seamless data flow and user interaction.
- **Robust Database:** Implemented MySQL for robust storage and retrieval, including database migrations.
- **Enhanced UI/UX:** Utilized Bootstrap for a professional, user-friendly interface, along with React Router, Axios, and hooks for navigation, HTTP handling, and state management.

## Setup Instructions

1. **Backend Setup:**
   - Clone this repository.
   - Navigate to the `backend` directory.
   - Run `mvn spring-boot:run` to start the Spring Boot backend server.

2. **Frontend Setup:**
   - Navigate to the `frontend` directory.
   - Run `npm install` to install dependencies.
   - Run `npm start` to start the React frontend server.

3. **Database Setup:**
   - Ensure MySQL is installed and running.
   - Create a new MySQL database named `employee_management`.
   - Import the database schema from `database/employee_management.sql`.

4. **Accessing the Application:**
   - Once both the backend and frontend servers are running, you can access the application at `http://localhost:3000`.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please fork the repository and submit a pull request with your changes.

## License

This project is licensed under the [MIT License](LICENSE).
