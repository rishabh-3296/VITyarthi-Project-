# Smart Campus Event & Participation Management System
## Project Report

### 1. Introduction
The project is a Java command-line system for managing college events and student participation.

### 2. Problem Statement
Manual event records can cause duplicate registrations, capacity violations, inconsistent attendance records and difficulty generating participation evidence.

### 3. Objectives
- Centralize event and student records.
- Automate registration rules.
- Track attendance.
- Generate certificates.
- Provide participation analytics.
- Demonstrate core Programming in Java concepts.

### 4. Functional Requirements
See `docs/requirements.md`.

### 5. Non-Functional Requirements
Performance, reliability, usability, maintainability, scalability and resource efficiency are documented in `docs/requirements.md`.

### 6. System Architecture
Layered CLI → Service → Repository → CSV storage. See `docs/diagrams/architecture.md`.

### 7. Design Diagrams
Use case, workflow, sequence, class and storage diagrams are included in `docs/diagrams/`.

### 8. Design Decisions
See `docs/design-decisions.md`.

### 9. Implementation Details
The implementation uses Java 17, Maven, OOP, interfaces, inheritance, collections, generics, enums, custom exceptions, CSV file handling, Java Streams, lambdas, `LocalDate`, and JUnit.

### 10. Screenshots / Results
Run the program with `mvn exec:java` and capture:
1. Main menu
2. Student creation/list
3. Event creation
4. Successful registration
5. Duplicate/capacity error
6. Attendance update
7. Certificate generation
8. Analytics report

### 11. Testing Approach
JUnit tests cover student creation/search and important registration business rules including duplicate registration and capacity enforcement.

### 12. Challenges Faced
- Separating UI from business logic.
- Persisting multiple related entities in CSV.
- Enforcing registration constraints consistently.
- Handling invalid user input.

### 13. Learnings & Key Takeaways
The project connects Java language features to a complete application workflow and demonstrates why modular architecture, validation and tests matter.

### 14. Future Enhancements
- JDBC/MySQL persistence.
- Login and role-based access.
- REST API.
- Web/mobile interface.
- PDF certificate generation.
- Email notifications.

### 15. References
- Oracle Java documentation
- JUnit 5 documentation
- Maven documentation
