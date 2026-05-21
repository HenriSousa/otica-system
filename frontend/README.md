# Ótica System Frontend - Angular 17

Frontend module for the Optical Store POS System built with Angular 17, TypeScript, and SCSS.

## 📋 Prerequisites

- Node.js (v18+)
- npm or yarn

## 🚀 Getting Started

### Install Dependencies

```bash
cd frontend
npm install
```

### Development Server

Start the development server with proxy configured for API calls:

```bash
npm start
```

The application will be available at `http://localhost:4200`

The proxy configuration automatically routes API calls from `/api/*` to `http://localhost:8080`

### Build for Production

```bash
npm run build
```

The build artifacts will be stored in the `dist/otica-system-frontend` directory.

## 📁 Project Structure

```
frontend/
├── src/
│   ├── app/
│   │   ├── components/
│   │   │   ├── customer-list/       # List customers
│   │   │   └── customer-form/       # Create/Edit customer
│   │   ├── services/
│   │   │   └── customer.service.ts  # API communication
│   │   ├── models/
│   │   │   └── customer.model.ts    # TypeScript interfaces
│   │   ├── app.component.*          # Root component
│   │   └── app.routes.ts            # Route definitions
│   ├── styles.scss                   # Global styles
│   ├── index.html                    # Main HTML
│   └── main.ts                       # Bootstrap file
├── angular.json                      # Angular CLI configuration
├── tsconfig.json                     # TypeScript configuration
├── package.json                      # Dependencies
└── README.md                         # This file
```

## ✨ Features

### Customer Management Module

- **List Customers**: View all registered customers in a table
- **Create Customer**: Form to register a new customer
- **Edit Customer**: Update customer information
- **Delete Customer**: Remove customer from the system
- **Validation**: Real-time form validation with error messages

### UI/UX

- Responsive design
- Clean and professional interface
- Bootstrap-inspired styling with SCSS
- Loading states and error handling
- User-friendly navigation

## 🔌 API Integration

The service communicates with the backend API at:

- **Base URL**: `http://localhost:8080/api`
- **Endpoints**:
  - `GET /api/customers` - List all customers
  - `POST /api/customers` - Create new customer
  - `GET /api/customers/:id` - Get customer by ID
  - `PUT /api/customers/:id` - Update customer
  - `DELETE /api/customers/:id` - Delete customer

## 📦 Technologies

- **Angular 17**: Frontend framework with standalone components
- **TypeScript 5.2**: Type-safe development
- **RxJS 7.8**: Reactive programming
- **SCSS**: Styling
- **Angular Forms**: Reactive forms with validation
- **Angular Router**: Client-side routing
- **HttpClient**: HTTP requests

## 🧪 Testing

Run unit tests:

```bash
npm test
```

## 📝 Notes

- The proxy configuration allows seamless API communication during development
- All forms include client-side validation
- The application follows Angular best practices with standalone components
- Errors are properly handled and displayed to the user

## 🎯 Future Enhancements

- Add authentication/authorization
- Implement search and filter functionality
- Add pagination for large datasets
- Implement data export (PDF/Excel)
- Add unit and integration tests
- Implement PWA features
- Add i18n support for multiple languages
