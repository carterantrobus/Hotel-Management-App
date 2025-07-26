# Hotel Management System

A comprehensive Spring Boot web application for managing hotel operations including customers, rooms, bookings, and services.

## 🏨 Features

- **Customer Management**: Add, view, and manage customer information
- **Room Management**: Manage hotel rooms with different types and pricing
- **Booking System**: Create and manage room bookings with date validation
- **Service Management**: Track additional services offered to guests
- **Dashboard**: Real-time overview of hotel statistics
- **Data Validation**: Comprehensive input validation and error handling
- **Responsive UI**: Modern, user-friendly interface

## 🛠️ Technology Stack

- **Backend**: Spring Boot 3.2.4, Java 17
- **Database**: H2 In-Memory Database (with JPA/Hibernate)
- **Frontend**: Thymeleaf templates, CSS3, HTML5
- **Build Tool**: Maven
- **Architecture**: MVC pattern with layered architecture

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd HotelManagementProject
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - Open your browser and go to: `http://localhost:8083`
   - The application will automatically populate with sample data

## 📊 Application Structure

```
src/main/java/com/example/hmp/
├── controller/          # REST controllers
├── model/              # JPA entities
├── repository/         # Data access layer
├── service/            # Business logic layer
├── config/             # Configuration classes
└── HmpApplication.java # Main application class
```

## 🎯 Key Features Implemented

### 1. **Data Validation & Error Handling**
- Comprehensive form validation for all entities
- User-friendly error messages
- Global exception handling
- Input sanitization and validation

### 2. **User Experience Improvements**
- Modern, responsive dashboard
- Intuitive navigation
- Success/error feedback messages
- Dropdown selections for related data

### 3. **Business Logic**
- Date validation for bookings
- Duplicate room number prevention
- Customer and room existence validation
- Sample data initialization

### 4. **Code Quality**
- Clean architecture with separation of concerns
- Proper dependency injection
- Consistent error handling
- Well-documented code

## 📱 Screenshots

The application includes:
- **Dashboard**: Overview with statistics and quick actions
- **Customer Management**: Add and view customer information
- **Room Management**: Manage room inventory and pricing
- **Booking System**: Create bookings with validation
- **Service Management**: Track hotel services

## 🔧 Configuration

The application uses the following default configuration:
- **Port**: 8083
- **Database**: H2 in-memory
- **Context Path**: `/`

Configuration can be modified in `src/main/resources/application.properties`

## 🧪 Testing

The application includes:
- Unit tests for business logic
- Integration tests for controllers
- Data validation tests

Run tests with:
```bash
mvn test
```

## 📈 Future Enhancements

Potential improvements for future versions:
- User authentication and authorization
- Payment processing integration
- Email notifications
- Advanced reporting and analytics
- Mobile-responsive design improvements
- Database migration to PostgreSQL/MySQL
- API endpoints for mobile applications

## 🤝 Contributing

This project was developed as a collaborative effort demonstrating:
- Spring Boot best practices
- Clean code principles
- User-centered design
- Comprehensive error handling
- Modern web development techniques

## 📄 License

This project is developed for educational and portfolio purposes.

---

**Developed with ❤️ using Spring Boot and modern web technologies** 