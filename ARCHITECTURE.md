# 🏗️ Arquitetura - Ótica System

## Visão Geral da Arquitetura

```
┌─────────────────────────────────────────────────────────────────────────┐
│                         APLICAÇÃO WEB - NAVEGADOR                       │
│                          http://localhost:4200                          │
└──────────────────────────────────────────────────────────────────────────┘
                                      │
                                      │ HTTP/REST
                                      ▼
┌─────────────────────────────────────────────────────────────────────────┐
│                    FRONTEND - ANGULAR 17 (Node.js)                      │
├─────────────────────────────────────────────────────────────────────────┤
│                                                                          │
│  ┌─────────────────────────────────────────────────────────────────┐   │
│  │                    APP COMPONENT (Root)                         │   │
│  │                     Navigation Bar                              │   │
│  └─────────────────────────────────────────────────────────────────┘   │
│                             │                                            │
│         ┌───────────────────┼───────────────────┐                       │
│         │                   │                   │                       │
│         ▼                   ▼                   ▼                       │
│  ┌────────────────┐ ┌────────────────┐ ┌──────────────────┐           │
│  │ CustomerList  │ │ CustomerForm   │ │   AppRoutes      │           │
│  │  Component    │ │  Component     │ │  (Routing Rules) │           │
│  └────────────────┘ └────────────────┘ └──────────────────┘           │
│         │                   │                                            │
│         └───────┬───────────┘                                            │
│                 │                                                        │
│                 ▼                                                        │
│         ┌───────────────────┐                                           │
│         │ CustomerService   │  (HTTP Client)                            │
│         │  - API calls      │                                           │
│         └───────────────────┘                                           │
│                 │                                                        │
│         ┌───────┼───────┐                                               │
│         │       │       │                                               │
│         ▼       ▼       ▼                                               │
│    GET   POST  PUT   DELETE                                             │
│                 │                                                        │
└─────────────────┼────────────────────────────────────────────────────────┘
                  │ HTTP/REST API
                  ▼
┌─────────────────────────────────────────────────────────────────────────┐
│                   BACKEND - SPRING BOOT 3 (Java 17)                    │
│                      http://localhost:8080                              │
├─────────────────────────────────────────────────────────────────────────┤
│                                                                          │
│              ┌──────────────────────────────────────┐                   │
│              │   CONTROLLER LAYER                   │                   │
│              │  CustomerController                  │                   │
│              │  ├─ POST /api/customers              │                   │
│              │  ├─ PUT /api/customers/{id}          │                   │
│              │  ├─ DELETE /api/customers/{id}       │                   │
│              │  ├─ GET /api/customers/{id}          │                   │
│              │  └─ GET /api/customers               │                   │
│              └──────────────────────────────────────┘                   │
│                          │                                               │
│              ┌───────────▼──────────────────────────┐                   │
│              │   DTO & VALIDATION LAYER            │                   │
│              │  ├─ CreateCustomerDTO                │                   │
│              │  ├─ UpdateCustomerDTO                │                   │
│              │  ├─ CustomerDTO                      │                   │
│              │  └─ Validation Rules                 │                   │
│              └──────────────────────────────────────┘                   │
│                          │                                               │
│              ┌───────────▼──────────────────────────┐                   │
│              │   SERVICE LAYER                      │                   │
│              │  CustomerServiceImpl                  │                   │
│              │  ├─ create()                         │                   │
│              │  ├─ update()                         │                   │
│              │  ├─ delete()                         │                   │
│              │  ├─ findById()                       │                   │
│              │  └─ findAll()                        │                   │
│              │  (Business Logic & Transactions)     │                   │
│              └──────────────────────────────────────┘                   │
│                          │                                               │
│              ┌───────────▼──────────────────────────┐                   │
│              │   REPOSITORY LAYER (JPA)            │                   │
│              │  CustomerRepository                  │                   │
│              │  (extends JpaRepository<T, ID>)      │                   │
│              │  - Hibernate ORM                     │                   │
│              └──────────────────────────────────────┘                   │
│                          │                                               │
│              ┌───────────▼──────────────────────────┐                   │
│              │   DOMAIN LAYER (DDD)                 │                   │
│              │  Customer Entity                     │                   │
│              │  ├─ id (PK)                          │                   │
│              │  ├─ name (required)                  │                   │
│              │  ├─ phone (required)                 │                   │
│              │  ├─ cpf (required, unique)           │                   │
│              │  ├─ birthDate                        │                   │
│              │  ├─ address (required)               │                   │
│              │  ├─ neighborhood                     │                   │
│              │  └─ referencePoint                   │                   │
│              └──────────────────────────────────────┘                   │
│                          │                                               │
│              ┌───────────▼──────────────────────────┐                   │
│              │   EXCEPTION HANDLING                 │                   │
│              │  GlobalExceptionHandler              │                   │
│              │  ├─ ResourceNotFoundException        │                   │
│              │  ├─ Validation Exceptions            │                   │
│              │  └─ Global Error Responses           │                   │
│              └──────────────────────────────────────┘                   │
│                          │                                               │
└──────────────────────────┼──────────────────────────────────────────────┘
                           │ JDBC
                           ▼
┌─────────────────────────────────────────────────────────────────────────┐
│                        MYSQL DATABASE                                   │
│                    (localhost:3306)                                      │
├─────────────────────────────────────────────────────────────────────────┤
│                                                                          │
│    DATABASE: otica_system                                               │
│    │                                                                     │
│    └─ TABLE: customers                                                  │
│       ├─ id (BIGINT, PK, AUTO_INCREMENT)                               │
│       ├─ name (VARCHAR, NOT NULL)                                       │
│       ├─ phone (VARCHAR, NOT NULL)                                      │
│       ├─ cpf (VARCHAR, NOT NULL, UNIQUE)                                │
│       ├─ birth_date (DATE, NULL)                                        │
│       ├─ address (VARCHAR, NOT NULL)                                    │
│       ├─ neighborhood (VARCHAR, NULL)                                   │
│       └─ reference_point (VARCHAR, NULL)                                │
│                                                                          │
└─────────────────────────────────────────────────────────────────────────┘
```

## Fluxo de Dados

### Criar Cliente (CREATE)

```
Frontend (Angular)
├─ UserInput (Form)
└─ CustomerFormComponent
   └─ form.submit()
      └─ CustomerService.create(customer)
         └─ HTTP POST to /api/customers
            └─ Backend (Spring Boot)
               └─ CustomerController.create(dto)
                  └─ GlobalExceptionHandler (Validation)
                  └─ CustomerServiceImpl.create(dto)
                     └─ Repository.save(entity)
                        └─ Hibernate ORM
                           └─ MySQL
                              └─ INSERT INTO customers
```

### Listar Clientes (READ)

```
Frontend (Angular)
├─ CustomerListComponent.ngOnInit()
└─ CustomerService.findAll()
   └─ HTTP GET to /api/customers
      └─ Backend (Spring Boot)
         └─ CustomerController.findAll()
            └─ CustomerServiceImpl.findAll()
               └─ Repository.findAll()
                  └─ Hibernate ORM
                     └─ MySQL
                        └─ SELECT * FROM customers
                           └─ JSON Response
                              └─ [CustomerDTO, ...]
                                 └─ Frontend displays in table
```

### Atualizar Cliente (UPDATE)

```
Frontend (Angular)
├─ CustomerFormComponent (edit mode)
├─ Load Customer (GET by ID)
└─ form.submit()
   └─ CustomerService.update(id, customer)
      └─ HTTP PUT to /api/customers/{id}
         └─ Backend (Spring Boot)
            └─ CustomerController.update(id, dto)
               └─ CustomerServiceImpl.update(id, dto)
                  └─ Repository.findById(id)
                  └─ Entity.setters() (update)
                  └─ Repository.save(entity)
                     └─ Hibernate ORM
                        └─ MySQL
                           └─ UPDATE customers WHERE id = ?
```

### Deletar Cliente (DELETE)

```
Frontend (Angular)
├─ CustomerListComponent
└─ delete(id)
   └─ confirm dialog
   └─ CustomerService.delete(id)
      └─ HTTP DELETE to /api/customers/{id}
         └─ Backend (Spring Boot)
            └─ CustomerController.delete(id)
               └─ CustomerServiceImpl.delete(id)
                  └─ Repository.existsById(id)
                  └─ Repository.deleteById(id)
                     └─ Hibernate ORM
                        └─ MySQL
                           └─ DELETE FROM customers WHERE id = ?
```

## Padrões de Design Utilizados

### Backend
- **Repository Pattern**: Abstração de acesso a dados
- **Service Layer**: Lógica de negócio centralizada
- **DTO Pattern**: Transferência de dados entre camadas
- **Dependency Injection**: IoC do Spring
- **Exception Handling**: Tratamento global de exceções
- **Layered Architecture**: Separação clara de responsabilidades

### Frontend
- **Component-based**: Componentes reutilizáveis
- **Service Layer**: Centralização de chamadas HTTP
- **Reactive Forms**: Validação e controle de formulários
- **RxJS/Observables**: Programação reativa
- **Routing**: Navegação entre views
- **Dependency Injection**: Angular's IoC

## Tecnologias por Camada

### Presentation Layer
- Angular 17 (TypeScript)
- RxJS
- Bootstrap/SCSS

### Business Logic Layer
- Spring Boot 3
- Spring Data JPA
- Hibernate

### Data Access Layer
- JPA/Hibernate ORM
- Spring Data Repository
- JDBC Driver

### Data Storage Layer
- MySQL 8
- InnoDB Engine

## Próximas Expansões

```
Future Modules:
│
├─ CRM Module
│  └─ Customer interactions history
│  └─ Follow-ups and campaigns
│
├─ Order Service (OS)
│  └─ Purchase orders
│  └─ Invoicing and receipts
│
├─ Inventory Module
│  └─ Stock management
│  └─ Supplier management
│
├─ Financial Management
│  └─ Payments and receipts
│  └─ Accounting integration
│
├─ Reports Module
│  └─ Sales reports
│  └─ Customer analytics
│
└─ Multi-Store Support
   └─ Multiple locations
   └─ Centralized management
```

## Segurança (Futuro)

```
Current State (v0.0.1):
└─ No authentication

Future Implementations:
├─ JWT Authentication
├─ Role-Based Access Control (RBAC)
├─ Data Encryption
├─ Audit Logging
├─ Rate Limiting
└─ CORS Configuration
```

---

**Diagrama criado em**: May 20, 2026
