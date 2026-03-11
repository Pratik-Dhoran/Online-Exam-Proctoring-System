# TechEval Platform

**TechEval Platform** is a simple *online examination system with basic proctoring and automated evaluation*.  
The goal of this project is to simulate a secure exam environment where students can attempt tests while the system monitors suspicious activity and calculates results automatically.

The application allows an **admin to create exams and questions**, while **students can register, attempt exams, and view their results**.

---

## Features

- User registration and login
- Role based access (Admin / Student)
- Admin can create exams and add questions
- Students can start exams and submit answers
- Automatic score calculation
- Basic proctoring with risk detection (tab switch / fullscreen exit)
- Result page with feedback
- Razorpay payment integration for course enrollment
- Cloud deployment with PostgreSQL database

---

## Tech Stack

**Backend**
- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA

**Frontend**
- HTML
- CSS
- JavaScript

**Database**
- PostgreSQL

**Deployment**
- Render Cloud

---

## Project Workflow

1. Users register and login into the system.
2. Admin creates exams and adds questions.
3. Students can view available exams and start an attempt.
4. While attempting the exam, the system tracks suspicious activity like tab switching or exiting fullscreen.
5. Students submit answers which are stored in the database.
6. After submission, the system evaluates answers and calculates the score.
7. Final result and feedback are shown to the student.

---

## Security

Authentication is implemented using **JWT tokens** and **Spring Security**.  
Passwords are encrypted using **BCrypt** before storing them in the database.

---

## Deployment

The application is deployed on **Render** with a managed **PostgreSQL database**.  
Environment variables are used for database configuration.

---
