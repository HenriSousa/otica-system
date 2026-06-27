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

### Service Order Management Endpoints

#### List All Service Orders
```http
GET /api/service-orders
```

#### Get Service Order by ID
```http
GET /api/service-orders/{id}
```

#### Search Service Orders by CPF
```http
GET /api/service-orders/cpf?cpf=12345678901
```

#### Create Service Order
```http
POST /api/service-orders
Content-Type: application/json

{
  "customerId": 1,
  "customerName": "João Silva",
  "customerPhone": "81999999999",
  "customerCpf": "12345678901",
  "customerAddress": "Rua Example, 123",
  "issueDate": "2026-05-20",
  "deliveryDate": "2026-05-30",
  "frameType": "Armação Completa",
  "frameBrand": "RayBan",
  "frameColor": "Preta",
  "rightEyeSphere": "-2.00",
  "rightEyeCylinder": "-0.50",
  "rightEyeAxis": "180",
  "leftEyeSphere": "-2.50",
  "leftEyeCylinder": "-0.75",
  "leftEyeAxis": "175",
  "ad": "3",
  "lensType": "Lente Multifocal",
  "lensValue": 800.00,
  "repairValue": 0.00,
  "otherValue": 0.00,
  "paymentMethod": "DEBITO",
  "status": "PENDENTE",
  "observations": "Cliente solicitou entrega rápida"
}
```

#### Update Service Order
```http
PUT /api/service-orders/{id}
Content-Type: application/json

{
  "id": 1,
  "customerId": 1,
  "customerName": "João Silva",
  "customerPhone": "81999999999",
  "customerCpf": "12345678901",
  "customerAddress": "Rua Example, 123",
  "issueDate": "2026-05-20",
  "deliveryDate": "2026-05-30",
  "frameType": "Armação Completa",
  "frameBrand": "RayBan",
  "frameColor": "Preta",
  "rightEyeSphere": "-2.00",
  "rightEyeCylinder": "-0.50",
  "rightEyeAxis": "180",
  "leftEyeSphere": "-2.50",
  "leftEyeCylinder": "-0.75",
  "leftEyeAxis": "175",
  "ad": "3",
  "lensType": "Lente Multifocal",
  "lensValue": 800.00,
  "repairValue": 0.00,
  "otherValue": 0.00,
  "paymentMethod": "DEBITO",
  "status": "CONCLUIDA",
  "observations": "Serviço concluído com sucesso"
}
```

#### Delete Service Order
```http
DELETE /api/service-orders/{id}
```


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

### Service Order Management
- ✅ Create new service orders
- ✅ List all service orders with CPF search
- ✅ View service order details
- ✅ Update service order information
- ✅ Delete service orders
- ✅ Full optical prescription tracking (OD/OE Esfera, Cilindro, Eixo, AD)
- ✅ Frame information tracking (tipo, marca, cor)
- ✅ Financial breakdown (Valor Lente, Valor Reparo, Outros Valores, Saldo Devedor)
- ✅ Payment method selection (Dinheiro, Débito, Crédito)
- ✅ Order status tracking (Pendente, Em Andamento, Concluída, Cancelada)
- ✅ PDF generation - Cliente (A4) for customer delivery
- ✅ PDF generation - Laboratório (A5) for laboratory production

### Business Rules
- Name is required
- Phone is required
- CPF is required and must be unique
- Address is required
- Birth date cannot be in the future
- Service Order must have a valid customer
- Service Order dates must be valid (delivery date >= issue date)
- Financial values default to zero and calculate total automatically

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

### Service Orders Table
```sql
CREATE TABLE service_orders (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  customer_id BIGINT NOT NULL,
  customer_name VARCHAR(255) NOT NULL,
  customer_phone VARCHAR(20) NOT NULL,
  customer_cpf VARCHAR(11) NOT NULL,
  customer_address VARCHAR(255) NOT NULL,
  issue_date DATE NOT NULL,
  delivery_date DATE,
  frame_type VARCHAR(100),
  frame_brand VARCHAR(100),
  frame_color VARCHAR(50),
  re VARCHAR(10),
  right_eye_sphere VARCHAR(10),
  right_eye_cylinder VARCHAR(10),
  right_eye_axis VARCHAR(10),
  left_eye_sphere VARCHAR(10),
  left_eye_cylinder VARCHAR(10),
  left_eye_axis VARCHAR(10),
  ad VARCHAR(10),
  lens_type VARCHAR(100),
  lens_value DECIMAL(10,2),
  dp VARCHAR(10),
  dnp VARCHAR(10),
  repair_value DECIMAL(10,2),
  other_value DECIMAL(10,2),
  payment_method VARCHAR(50),
  status VARCHAR(50),
  observations TEXT,
  FOREIGN KEY (customer_id) REFERENCES customers(id)
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

- [x] Customer Management Module
- [x] Service Order Module with PDF generation
- [ ] CRM Module (Customer relationship management)
- [ ] Purchase Order Module (Inventory integration)
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

**Version**: 0.1.0  
**Last Updated**: June 13, 2026
