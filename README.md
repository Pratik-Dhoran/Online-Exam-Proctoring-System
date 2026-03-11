# TechEval Platform – Online Examination & Proctoring System

TechEval Platform is a backend-focused online examination system built using Spring Boot that allows students to attempt exams securely while admins can manage exams and questions.
The system also includes basic automated risk detection during exams, dynamic exam rendering, result calculation, and course enrollment using Razorpay.

---

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA (Hibernate)
- Spring Security
- JWT Authentication
- PostgreSQL
- Razorpay Payment Gateway
- HTML, CSS, JavaScript
- Maven
- Render Cloud Deployment

---

## Project Structure

The project follows layered architecture:

- Controller Layer → Handles REST APIs

- Service Layer → Business logic implementation

- Repository Layer → Database interaction using JPA

- Entity Layer → Database table mapping

- DTO Layer → Clean request and response models

- Config Layer → Security, JWT filter, and password encoding

This structure helps maintain clean code, scalability, and separation of concerns.

---

## Features

• User Registration and Login  
• JWT based Authentication  
• Role Based Access (Admin / Student)  
• Create Exams (Admin)  
• Add Questions to Exams  
• Dynamic Exam Rendering  
• Answer Submission System  
• Automated Risk Detection (Proctoring Logs)  
• Score Calculation and Result Evaluation  
• Feedback based on Score + Risk Score  
• Razorpay Course Enrollment  
• Fullscreen Exam Enforcement  
• Countdown Timer for Exams  
• Cloud Deployment with PostgreSQL Database  

---

## Exam Flow (How It Works)

1. Student registers and logs into the platform.

2. The dashboard loads all available exams dynamically.

3. When the student clicks Start Exam, the system creates a new Attempt record.

4. Exam paper is fetched using the exam ID and questions are rendered dynamically.

5. Each selected option is saved instantly using an answer submission API.

6. During the exam, the system tracks suspicious behaviour like tab switching or exiting fullscreen.

7. These events are stored as Proctor Logs and increase the risk score.

8. After submission, the backend evaluates answers and calculates the final score.

9. Result page displays score, risk score, pass/fail status, and feedback.

---

## Risk Detection Logic

The system includes a basic automated proctoring mechanism.

Suspicious events such as:

- Tab switching

- Exiting fullscreen

- Page focus loss

are recorded as Proctor Logs.

Each event increases a risk score, which is later used along with exam score to determine the final feedback.

This approach simulates AI-like automated exam monitoring.

---

## Database entities include:

- User

- Exam

- Question

- Option

- Attempt

- Answer

- ProctorLog

---

## Payment Integration

The platform includes Razorpay integration for course enrollment.

---

## Deployment

The application is deployed on Render Cloud.

Link :- https://online-exam-proctoring-system-9755.onrender.com

---

## Author

Pratik Dhoran
Backend Developer | Java & Spring Boot Enthusiast

This project was built to practice backend system design, security implementation, database relationships, and cloud deployment while simulating a real-world online examination platform.
