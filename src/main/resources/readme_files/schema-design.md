# Database Schema Design - Smart Clinic Management System

This document outlines the MySQL database structure for the Smart Clinic application.

## Entity Relationship Summary
The database consists of 4 main tables: `admins`, `doctors`, `patients`, and `appointments`.

---

### 1. Admins Table
Stores administrative account information.
| Column | Type | Constraints |
| :--- | :--- | :--- |
| id | BIGINT | Primary Key, Auto Increment |
| username | VARCHAR(50) | Unique, Not Null |
| password | VARCHAR(255) | Not Null |

### 2. Doctors Table
Stores doctor profiles and their specializations.
| Column | Type | Constraints |
| :--- | :--- | :--- |
| id | BIGINT | Primary Key, Auto Increment |
| name | VARCHAR(100) | Not Null |
| specialty | VARCHAR(100) | Not Null |
| available_times | TEXT | (JSON or Comma-separated list) |

### 3. Patients Table
Stores patient personal details.
| Column | Type | Constraints |
| :--- | :--- | :--- |
| id | BIGINT | Primary Key, Auto Increment |
| name | VARCHAR(100) | Not Null |
| email | VARCHAR(100) | Unique, Not Null |
| phone | VARCHAR(20) | Not Null |

### 4. Appointments Table
Connects patients and doctors for scheduled visits.
| Column | Type | Constraints |
| :--- | :--- | :--- |
| id | BIGINT | Primary Key, Auto Increment |
| doctor_id | BIGINT | Foreign Key (doctors.id) |
| patient_id | BIGINT | Foreign Key (patients.id) |
| appointment_time | DATETIME | Not Null |
| status | VARCHAR(20) | (e.g., PENDING, COMPLETED) |

---

## Key Relationships
- **One-to-Many:** One Doctor can have many Appointments.
- **One-to-Many:** One Patient can have many Appointments.
- **Many-to-One:** Appointments link back to a specific Doctor and Patient.