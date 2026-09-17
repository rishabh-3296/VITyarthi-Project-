# System Architecture

```mermaid
flowchart TD
    UI[CLI UI] --> S[Service Layer]
    S --> R[Repository Layer]
    R --> F[(CSV Files)]
    S --> M[Domain Models]
    S --> E[Custom Exceptions]
```
