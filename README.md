# VITyarthi-Project-

Smart Campus Event & Participation Management System
A Java 17 command-line application for managing students, campus events, registrations, attendance, certificates, and participation analytics.

Why this project
The system demonstrates core Programming in Java concepts in a realistic workflow: OOP, inheritance, abstraction, interfaces, collections, generics, enums, exception handling, file I/O, Java Streams, the Date/Time API, validation, Maven and JUnit testing.

Features
Student CRUD and search
Event creation, update, deletion and capacity control
Student event registration and cancellation
Attendance marking
Certificate generation and lookup
Participation and attendance analytics
CSV persistence in the data/ directory
Custom exceptions and input validation
Automated JUnit tests
Requirements
Java JDK 17+
Maven 3.8+
Run from terminal
mvn clean test
mvn exec:java
The program creates/updates CSV files under data/.

Project structure
src/main/java/com/smartcampus/
  model/        Domain classes
  enums/        Enumerations
  interfaces/   Contracts
  repository/   CSV persistence
  service/      Business logic
  exception/    Custom exceptions
  util/         Validation and file utilities
  ui/           CLI menus
  Main.java
src/test/java/  JUnit tests
docs/diagrams/  Design diagrams in Mermaid
data/           Runtime CSV storage
Testing
mvn test
Java concepts demonstrated
Encapsulation, inheritance, polymorphism, abstraction, interfaces, collections (List, Map, Set), generics, exceptions, file handling, streams/lambdas, enums, LocalDate, packages, Maven and JUnit.

Design artifacts
See docs/ for problem statement, requirements, architecture, workflow, use case, sequence, class and storage diagrams.

Sample workflow
Add a student.
Create an event.
Register the student for the event.
Mark attendance.
Generate a certificate.
Open reports to inspect participation.
Academic note
This project is designed as a course-domain implementation for Programming in Java. Customize names, sample data, screenshots and explanations to reflect your own work before submission.
