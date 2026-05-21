# Ótica System - Web POS for Optical Stores

A comprehensive Point of Sale (POS) system designed for optical stores, built with Java 17 Spring Boot 3 backend and Angular 17 frontend.

## 🎯 Project Overview

Ótica System is a scalable web-based POS solution following SOLID principles, Domain-Driven Design (DDD), and Clean Architecture. Currently implemented is the **Customer Management Module** with plans for future expansion including CRM, Order Service, Inventory Management, Financial Management, Reports, and Multi-store support.

## 📋 Architecture

### Backend Stack
- **Java 17** - Language
- **Spring Boot 3** - Framework
- **MySQL 8** - Database
- **Maven** - Build tool
- **JPA/Hibernate** - ORM
- **REST API** - API standards

### Frontend Stack
- **Angular 17** - Framework
- **TypeScript 5.2** - Language
- **SCSS** - Styling
- **RxJS** - Reactive programming
- **Standalone Components** - Angular approach

## 📁 Project Structure

```
otica-system/
├── src/                          # Backend source
│   ├── main/
│   │   ├── java/com/otica_system/
│   │   │   ├── domain/           # Domain entities (DDD)
│   │   │   ├── application/      # Application services
│   │   │   ├── infrastructure/   # Infrastructure layer
│   │   │   ├── controller/       # REST Controllers
│   │   │   ├── dto/              # Data Transfer Objects
│   │   │   ├── exception/        # Exception handling
│   │   │   ├── repository/       # Data access
│   │   │   └── service/          # Business logic
│   │   └── resources/
│   │       └── application.properties  # Configuration
│   └── test/                     # Test suite
├── frontend/                     # Angular application
│   ├── src/
│   │   ├── app/
│   │   │   ├── components/       # Angular components
│   │   │   ├── services/         # API services
│   │   │   ├── models/           # TypeScript interfaces
│   │   │   └── app.routes.ts     # Routes
│   │   └── styles.scss           # Global styles
│   ├── angular.json              # Angular configuration
│   └── package.json              # Dependencies
├── pom.xml                       # Maven configuration
└── README.md                     # This file
```

## 🚀 Getting Started

### Prerequisites
- Java 17 JDK
- Node.js 18+
- MySQL 8
- Maven 3.8+

### Backend Setup

1. **Install MySQL and create database**:
   ```sql
   CREATE DATABASE otica_system;
   ```

2. **Configure database connection** in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/otica_system
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

3. **Build and run the backend**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   Backend will start at `http://localhost:8080`

### Frontend Setup

1. **Navigate to frontend directory**:
   ```bash
   cd frontend
   ```

2. **Install dependencies**:
   ```bash
   npm install
   ```

3. **Start development server**:
   ```bash
   npm start
   ```

   Frontend will start at `http://localhost:4200`

## 📚 API Documentation

### Customer Management Endpoints

#### List All Customers
```http
GET /api/customers
```

#### Get Customer by ID
```http
GET /api/customers/{id}
```

#### Create Customer
```http
POST /api/customers
Content-Type: application/json

{
  "name": "John Doe",
  "phone": "11999999999",
  "cpf": "12345678901",
  "birthDate": "1990-01-01",
  "address": "Rua Example, 123",
  "neighborhood": "Centro",
  "referencePoint": "Próximo à farmácia"
}
```

#### Update Customer
```http
PUT /api/customers/{id}
Content-Type: application/json

{
  "name": "John Updated",
  "phone": "11999999999",
  "cpf": "12345678901",
  "address": "Rua Example, 456"
}
```

#### Delete Customer
```http
DELETE /api/customers/{id}
```

## 🏛️ Design Patterns & Architecture

### Backend
- **Domain-Driven Design (DDD)** - Domain entities and business logic separation
- **Clean Architecture** - Layered architecture with clear separation of concerns
- **Repository Pattern** - Data access abstraction
- **Service Layer** - Business logic encapsulation
- **DTO Pattern** - Data transfer between layers
- **Exception Handling** - Global exception handler for consistent error responses
- **Dependency Injection** - Spring's IoC container

### Frontend
- **Standalone Components** - Modern Angular approach
- **Reactive Forms** - Form validation and control
- **Service Layer** - Centralized API communication
- **RxJS** - Reactive programming for async operations
- **Component-based Architecture** - Reusable UI components

## ✨ Features

### Customer Management
- ✅ Create new customers
- ✅ List all customers with pagination
- ✅ View customer details
- ✅ Update customer information
- ✅ Delete customers
- ✅ Form validation (required fields, CPF format, etc.)
- ✅ Error handling and user feedback

### Business Rules
- Name is required
- Phone is required
- CPF is required and must be unique
- Address is required
- Birth date cannot be in the future

## 🔒 Validation

### Backend Validation
- Entity-level validation with constraints
- Service-level business rule validation
- DTO validation with JSR-303

### Frontend Validation
- Real-time form validation
- Custom validators for CPF, phone, etc.
- User-friendly error messages

## 📊 Database Schema

### Customers Table
```sql
CREATE TABLE customers (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  cpf VARCHAR(255) NOT NULL UNIQUE,
  birth_date DATE,
  address VARCHAR(255) NOT NULL,
  neighborhood VARCHAR(255),
  reference_point VARCHAR(255)
);
```

## 🔄 Continuous Integration / Continuous Deployment

### Build Backend
```bash
mvn clean package -DskipTests
```

### Build Frontend
```bash
cd frontend
npm run build
```

## 📝 Code Standards

- Follow SOLID principles
- Clean Code practices
- Meaningful naming conventions
- Proper separation of concerns
- Comprehensive error handling
- Type safety (TypeScript on frontend, Java generics on backend)

## 🚀 Future Roadmap

- [ ] CRM Module (Customer relationship management)
- [ ] Order Service Module (Purchase orders, invoicing)
- [ ] Inventory Module (Stock management, suppliers)
- [ ] Financial Module (Payments, accounting)
- [ ] Reports Module (Sales, customer analytics)
- [ ] Multi-store Support (Multiple location management)
- [ ] Authentication & Authorization
- [ ] Advanced Search & Filtering
- [ ] Data Export (PDF, Excel)
- [ ] Mobile App Support
- [ ] Real-time Notifications
- [ ] Audit Trail & Logging

## 🤝 Contributing

Contributions are welcome! Please follow the project's coding standards and architecture patterns.

## 📄 License

This project is licensed under MIT License.

## 📞 Support

For questions or issues, please create an issue in the repository.

---

**Version**: 0.0.1  
**Last Updated**: May 20, 2026
