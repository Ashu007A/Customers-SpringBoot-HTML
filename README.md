# Customer Management System

This is a CRUD (Create, Read, Update, Delete) application for managing customer data. It allows users to perform operations like adding new customers, updating existing ones, deleting customers, and viewing the list of customers.

## Technologies Used

- Backend: Spring Boot (Java)
- Frontend: HTML/CSS/JavaScript
- Database: MySQL
- Authentication: JWT (JSON Web Tokens)

## Features

- User authentication with JWT
- Create, read, update, and delete customers
- Synchronization of customer data with a remote API
- Search and sorting functionality for customer list
- Basic UI with HTML forms and tables

## Setup Instructions

1. Clone the repository:

```bash
git clone https://github.com/your-username/customer-management-system.git
Set up MySQL database:

Create a MySQL database named customer_management_system.
Update application.properties file with your MySQL database credentials.
Build and run the Spring Boot application:

cd customer-management-system
./mvnw spring-boot:run
Access the application:

Open your web browser and go to http://localhost:8080.

Additional Information
The application uses Spring Security for user authentication with JWT tokens.
You can customize the UI by modifying the HTML/CSS files in the src/main/resources/templates directory.
Make sure to set up the remote API URL and token in the application.properties file for synchronization functionality.

This README file provides an overview of your project, setup instructions, and additional information that might be helpful for users or contributors. Make sure to update it with relevant details specific to your project.

Let me know if you need further assistance!
