# Online Learning System

Java Full Stack Online Learning Platform built with Java 21, Spring Boot, Spring Security, JWT, React, Axios and MySQL.

## Features
- Student and Instructor roles
- Registration and JWT login
- Course browsing and search
- Course enrollment
- Lessons
- Learning progress
- REST APIs
- MySQL persistence
- Responsive React UI

## Structure
Online_Learning_System/\n├── backend/\n├── frontend/\n├── database/\n└── README.md

## MySQL
Create the database with database/schema.sql. The backend uses root and reads DB_PASSWORD from the environment. Local default is root123.

## Run backend
cd backend\nmvn spring-boot:run

Backend: http://localhost:8080

## Run frontend
cd frontend\nnpm install\nnpm run dev

Frontend: http://localhost:5173
