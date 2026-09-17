# Requirements

## Functional Requirements
- FR1: Add, update, delete, search and list students.
- FR2: Create, update, delete, search and list events.
- FR3: Register a student only once for an event.
- FR4: Prevent registration when event capacity is full.
- FR5: Cancel registrations.
- FR6: Mark attendance for registered students.
- FR7: Generate a certificate for an attended event.
- FR8: Produce student/event participation reports.

## Non-Functional Requirements
- Performance: common CLI operations should remain responsive for the intended small/medium dataset.
- Reliability: invalid input and business-rule violations must be handled without terminating the application.
- Usability: menus and error messages must be clear.
- Maintainability: UI, services, repositories and models are separated.
- Scalability: repository interfaces isolate storage from business logic.
- Resource efficiency: records are loaded only when the application starts and persisted after mutations.
