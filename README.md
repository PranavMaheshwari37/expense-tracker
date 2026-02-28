# Expense Tracker – Spring Boot REST API

A simple **Expense Tracker backend application** built using **Spring Boot**, **Spring Data JPA**, and **MySQL**.  
This project allows users to manage expenses, view totals, and track spending efficiently.

---

## 🚀 Features

- Create and manage users
- Add expenses for a specific user
- Fetch all expenses of a user
- Get total expenses for a user
- Filter expenses by category
- Filter expenses by date range
- RESTful API design
- MySQL database integration

---

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot 3.2.x**
- **Spring Data JPA**
- **Hibernate**
- **MySQL**
- **Gradle**
- **Postman** (for API testing)

---

## 📂 Project Structure
# Expense Tracker – Spring Boot REST API

A simple **Expense Tracker backend application** built using **Spring Boot**, **Spring Data JPA**, and **MySQL**.  
This project allows users to manage expenses, view totals, and track spending efficiently.

---

## 🚀 Features

- Create and manage users
- Add expenses for a specific user
- Fetch all expenses of a user
- Get total expenses for a user
- Filter expenses by category
- Filter expenses by date range
- RESTful API design
- MySQL database integration

---

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot 3.2.x**
- **Spring Data JPA**
- **Hibernate**
- **MySQL**
- **Gradle**
- **Postman** (for API testing)

---

## 📂 Project Structure
expense-tracker
├── controller
│ └── ExpenseController.java
├── service
│ ├── ExpenseService.java
│ └── impl
│ └── ExpenseServiceImpl.java
├── repository
│ ├── ExpenseRepository.java
│ └── UserRepository.java
├── entity
│ ├── Expense.java
│ └── User.java
├── dto
│ ├── ExpenseRequestDto.java
│ └── ExpenseResponseDto.java
└── ExpenseTrackerApplication.java


---

## ⚙️ Database Configuration

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
---

🔗 API Endpoints
👤 User APIs
Method	Endpoint	Description
POST	/api/users	Create a new user
GET	/api/users	Get all users
---

💰 Expense APIs (User Based)
Method	Endpoint	Description
POST	/api/users/{userId}/expenses	Add expense for user
GET	/api/users/{userId}/expenses	Get all expenses of user
GET	/api/users/{userId}/expenses/total	Get total expense of user
---

🌍 Global Expense APIs
Method	Endpoint	Description
GET	/api/expenses	Get all expenses
GET	/api/expenses/{id}	Get expense by ID
GET	/api/expenses/category/{category}	Get expenses by category
GET	/api/expenses/date-range?start=YYYY-MM-DD&end=YYYY-MM-DD	Get expenses by date range
GET	/api/expenses/total	Get total expenses
---

▶️ How to Run the Project
git clone https://github.com/your-username/expense-tracker.git
cd expense-tracker
./gradlew bootRun
---

📌 Future Enhancements

Exception handling & global error responses

User authentication & authorization

Swagger API documentation

Pagination & sorting

Monthly expense reports

👨‍💻 Author

Pranav Maheshwari
M.Tech Student | Java & Spring Boot Developer
