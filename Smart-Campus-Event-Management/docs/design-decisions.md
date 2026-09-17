# Design Decisions & Rationale

## Layered design
The UI calls services; services enforce business rules; repositories handle persistence. This prevents business logic from being embedded in menu code.

## CSV storage
CSV is dependency-light and transparent for a CLI academic project. The repository layer makes a later database migration possible without rewriting the services.

## Collections
Lists are used for ordered records, maps for efficient ID lookup and sets for duplicate-sensitive attendance/registration checks.

## Interfaces and abstraction
`Searchable`, `Reportable` and `Registrable` express reusable contracts. `User` is abstract because student and organizer are specialized user types.

## Exceptions
Domain-specific exceptions make business failures explicit and easier to test.

## Streams and lambdas
Analytics and filtering use Java Streams to demonstrate modern Java collection processing.
