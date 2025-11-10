# Vehicle Rental Application

A comprehensive web-based vehicle rental management system built using Java Enterprise Edition (J2EE) technologies. This application provides separate interfaces for administrators and customers to manage vehicle rentals, bookings, discounts, and feedback.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Database Schema](#database-schema)
- [Key Components](#key-components)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)

## 🎯 Project Overview

This is a full-stack web application for managing vehicle rentals. The system supports two types of users:
- **Administrators**: Manage vehicles, customers, bookings, discounts, and view feedback
- **Customers/Users**: Browse available vehicles, make bookings, view discounts, manage their bookings, and submit feedback

The application follows the MVC (Model-View-Controller) architectural pattern with a custom framework implementation.

## ✨ Features

### Admin Features
- **Authentication**: Secure admin login system
- **Customer Management**: 
  - View all registered customers
  - Add new customers manually
- **Vehicle Management**:
  - View all vehicles in the system
  - Add new vehicles (name, type, registration number, price)
  - View available vehicles
  - View unavailable vehicles
  - Modify vehicle availability status (available/unavailable)
- **Booking Management**: View all booking details across all users
- **Discount Management**:
  - View all discount rules
  - Add new discount rules (based on days and number of vehicles)
  - Update existing discount rules
- **Feedback Management**: View all customer feedback

### User/Customer Features
- **Registration**: New user registration with validation
- **Authentication**: Secure user login
- **Vehicle Browsing**: 
  - View available vehicles for rent
  - View vehicle details (name, type, registration, price)
- **Booking Management**:
  - Book vehicles with date selection
  - Specify number of days and quantity
  - Automatic discount calculation based on booking parameters
  - View booking confirmation
  - View all personal bookings
  - Cancel bookings
- **Discount Viewing**: View available discount offers
- **Feedback System**: Submit feedback for rented vehicles

## 🛠️ Technologies Used

### Backend Technologies
- **Java**: Core programming language
- **Java Servlet API 3.1.0**: Server-side request handling
- **JSP (JavaServer Pages)**: Dynamic web page generation
- **JDBC**: Database connectivity
- **MySQL Connector/J 8.0.29**: MySQL database driver
- **Apache Log4j 1.2.8**: Logging framework
- **Apache Commons DBCP 1.2.1**: Database connection pooling
- **Apache Commons Pool 1.2**: Object pooling support
- **Apache Commons Collections 3.1**: Collection utilities
- **Apache Commons Lang 2.1**: String and object utilities

### Frontend Technologies
- **HTML**: Markup language
- **CSS**: Styling and layout
- **JSP**: Server-side rendering
- **JSTL 1.2**: Java Standard Tag Library for JSP

### Database
- **MySQL**: Relational database management system
- **Database Name**: `vehicle_rent_application_db`

### Application Server
- **Apache Tomcat**: Servlet container and web server

### Development Tools
- **Eclipse JEE**: Integrated Development Environment
- **Maven/Gradle**: Build automation (implied from structure)

## 🏗️ Architecture

The application follows a **custom MVC (Model-View-Controller) framework**:

### MVC Pattern Implementation

1. **Model Layer** (`com.keane.training.domain`):
   - Domain objects representing business entities
   - POJOs (Plain Old Java Objects) with getters/setters

2. **View Layer** (`src/main/webapp/pages`):
   - JSP files for user interface
   - CSS files for styling
   - Static resources (images)

3. **Controller Layer** (`com.keane.mvc`):
   - Custom MVC framework with `MvcController` servlet
   - Request routing through `mvc.properties` configuration
   - Handler classes implementing `HttpRequestHandler` interface

4. **Data Access Layer** (`com.keane.training.dao`):
   - DAO (Data Access Object) pattern
   - Database operations abstraction
   - SQL query mapping through `SqlMapper`

5. **Framework Layer** (`com.keane.dbfw`, `com.keane.dbcon`):
   - Custom database framework
   - Connection pooling and management
   - Parameter mapping and result mapping utilities

### Request Flow

```
User Request → MvcController → Handler (from mvc.properties) → DAO → Database
                                                                    ↓
User Response ← JSP View ← Handler ← DAO ← Database Result
```

## 📁 Project Structure

```
ParaLokesh_VehicleRentApplication/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── keane/
│       │           ├── dbcon/              # Database Connection Management
│       │           │   ├── ConnectionHolder.java
│       │           │   └── DBConnectionException.java
│       │           │
│       │           ├── dbfw/               # Database Framework
│       │           │   ├── DBHelper.java
│       │           │   ├── DBFWException.java
│       │           │   ├── ParamMapper.java
│       │           │   ├── ResultMapper.java
│       │           │   ├── OutParamMapper.java
│       │           │   └── OutTypeMapper.java
│       │           │
│       │           ├── mvc/                # MVC Framework
│       │           │   ├── MvcController.java
│       │           │   ├── HttpRequestHandler.java
│       │           │   ├── MvcException.java
│       │           │   └── MvcUtil.java
│       │           │
│       │           └── training/
│       │               ├── domain/          # Domain Models
│       │               │   ├── User.java
│       │               │   ├── UserDetails.java
│       │               │   ├── AdminDetails.java
│       │               │   ├── VehicleDetails.java
│       │               │   ├── BookingDetails.java
│       │               │   ├── DiscountDetails.java
│       │               │   └── FeedbackDetails.java
│       │               │
│       │               ├── dao/             # Data Access Objects
│       │               │   ├── UserDAO.java
│       │               │   ├── AdminDAO.java
│       │               │   ├── LoginDAO.java
│       │               │   ├── RegisterDAO.java
│       │               │   ├── SqlMapper.java
│       │               │   ├── DAOAppException.java
│       │               │   └── AdminDAOTest.java
│       │               │
│       │               └── web/
│       │                   └── handlers/    # Request Handlers
│       │                       ├── UserProcess.java
│       │                       ├── AdminProcess.java
│       │                       ├── RegisterUser.java
│       │                       ├── RegisterMaster.java
│       │                       ├── SearchProduct.java
│       │                       ├── MyListenerClass.java
│       │                       └── MyServersideScript.java
│       │
│       └── webapp/
│           ├── META-INF/
│           │   ├── context.xml             # Database connection configuration
│           │   └── MANIFEST.MF
│           │
│           ├── WEB-INF/
│           │   ├── web.xml                 # Web application deployment descriptor
│           │   ├── mvc.properties          # Handler mapping configuration
│           │   └── lib/                    # JAR dependencies
│           │
│           └── pages/                      # JSP Views
│               ├── index.jsp               # Landing page
│               ├── AdminLogin.jsp
│               ├── Adminhome.jsp
│               ├── AdminAddCustomer.jsp
│               ├── AdminAddVehicle.jsp
│               ├── AdminAddDiscount.jsp
│               ├── AdminUpdateDiscount.jsp
│               ├── AllUserDetails.jsp
│               ├── AllVehiclesDetails.jsp
│               ├── AllBookingDetails.jsp
│               ├── AllDiscountDetails.jsp
│               ├── AllFeedbackDetails.jsp
│               ├── AvailableVehicles.jsp
│               ├── UnavailableVehicles.jsp
│               ├── ModifyVehicleAvailableStatus.jsp
│               ├── ModifyVehicleUnavailableStatus.jsp
│               ├── UserLogin.jsp
│               ├── UserRegister.jsp
│               ├── UserHome.jsp
│               ├── UserAvailableVehicle.jsp
│               ├── UserBookingConfirmation.jsp
│               ├── UserAllBookedVehicles.jsp
│               ├── UserViewDiscounts.jsp
│               ├── UserFeedback.jsp
│               ├── error.jsp
│               ├── success.jsp
│               ├── invalidDetails.jsp
│               └── images/                 # Static images
│
└── build/                                  # Compiled classes
    └── classes/
```

## 🗄️ Database Schema

Based on the SQL queries in `SqlMapper.java`, the database consists of the following tables:

### 1. `admin_details`
- `adminID` (INT, Primary Key, Auto-increment)
- `adminName` (VARCHAR)
- `adminPassword` (VARCHAR)

### 2. `user_details`
- `userID` (INT, Primary Key, Auto-increment)
- `userName` (VARCHAR, Unique)
- `userPassword` (VARCHAR)
- `city` (VARCHAR)
- `email` (VARCHAR)
- `phoneNumber` (VARCHAR)

### 3. `vehicle_details`
- `vehicleID` (INT, Primary Key, Auto-increment)
- `vehicleName` (VARCHAR)
- `vehicleType` (VARCHAR)
- `vehicleRegNo` (VARCHAR, Unique)
- `vehiclePrice` (FLOAT)
- `vehicleAvailableStatus` (VARCHAR) - Values: "yes" or "no"

### 4. `booking_details`
- `bookingID` (INT, Primary Key, Auto-increment)
- `userID` (INT, Foreign Key → user_details.userID)
- `vehicleID` (INT, Foreign Key → vehicle_details.vehicleID)
- `purchasedDate` (DATE/VARCHAR)
- `no_of_Days` (INT)
- `bookedPrice` (FLOAT)
- `vehicle_return_status` (VARCHAR) - Values: "yes" or "no"
- `quantity` (INT)

### 5. `discount`
- `days` (INT)
- `no_of_vehicle` (INT)
- `discount` (INT) - Percentage discount
- Composite Primary Key: (days, no_of_vehicle)

### 6. `feedback`
- `userID` (INT, Foreign Key → user_details.userID)
- `vehicleID` (INT, Foreign Key → vehicle_details.vehicleID)
- `feedback` (TEXT)
- Composite Primary Key: (userID, vehicleID)

## 🔧 Key Components

### 1. Custom MVC Framework (`com.keane.mvc`)

**MvcController**: Front controller servlet that routes all requests
- Maps URL patterns (`.do` extension) to handler classes
- Uses `mvc.properties` for handler configuration
- Implements both GET and POST request handling

**HttpRequestHandler**: Interface implemented by all request handlers
- `handle(HttpServletRequest, HttpServletResponse)` method

### 2. Database Framework (`com.keane.dbfw`)

**DBHelper**: Utility class for database operations
- `executeSelect()`: Execute SELECT queries with parameter mapping
- `executeUpdate()`: Execute INSERT, UPDATE, DELETE queries
- `executeProc()`: Execute stored procedures
- Automatic resource management (connection, statement, result set)

**ParamMapper**: Interface for mapping parameters to PreparedStatement
**ResultMapper**: Interface for mapping ResultSet rows to domain objects

### 3. Connection Management (`com.keane.dbcon`)

**ConnectionHolder**: Singleton pattern for database connection management
- Uses JNDI DataSource lookup (`jdbc/MyDB`)
- Connection pooling via Apache Commons DBCP
- Lifecycle management through ServletContextListener

### 4. Request Handlers

**UserProcess**: Handles all user/customer operations
- Login, Registration
- Vehicle browsing and booking
- Booking management (view, cancel)
- Discount viewing
- Feedback submission

**AdminProcess**: Handles all administrator operations
- Admin login
- CRUD operations for customers, vehicles, discounts
- View all bookings and feedback
- Vehicle status management

### 5. Data Access Layer

**UserDAO**: Data access methods for user operations
- User authentication and registration
- Vehicle queries (available, by ID, by name)
- Booking operations (add, view, delete)
- Discount calculation
- Feedback operations

**AdminDAO**: Data access methods for admin operations
- Admin authentication
- User management
- Vehicle management (CRUD)
- Discount management (CRUD)
- Booking and feedback queries

**SqlMapper**: Centralized SQL query definitions and result mappers
- All SQL queries as static final strings
- ResultSet mappers for each domain object

## 🚀 Setup Instructions

### Prerequisites
1. **Java Development Kit (JDK)**: Version 8 or higher
2. **Apache Tomcat**: Version 8.5 or higher
3. **MySQL Server**: Version 5.7 or higher
4. **Eclipse IDE** (or any Java IDE)
5. **MySQL Workbench** (optional, for database management)

### Database Setup

1. **Create Database**:
   ```sql
   CREATE DATABASE vehicle_rent_application_db;
   USE vehicle_rent_application_db;
   ```

2. **Create Tables**:
   ```sql
   -- Admin table
   CREATE TABLE admin_details (
       adminID INT AUTO_INCREMENT PRIMARY KEY,
       adminName VARCHAR(100) NOT NULL,
       adminPassword VARCHAR(100) NOT NULL
   );

   -- User table
   CREATE TABLE user_details (
       userID INT AUTO_INCREMENT PRIMARY KEY,
       userName VARCHAR(100) NOT NULL UNIQUE,
       userPassword VARCHAR(100) NOT NULL,
       city VARCHAR(100),
       email VARCHAR(100),
       phoneNumber VARCHAR(20)
   );

   -- Vehicle table
   CREATE TABLE vehicle_details (
       vehicleID INT AUTO_INCREMENT PRIMARY KEY,
       vehicleName VARCHAR(100) NOT NULL,
       vehicleType VARCHAR(50),
       vehicleRegNo VARCHAR(50) NOT NULL UNIQUE,
       vehiclePrice FLOAT NOT NULL,
       vehicleAvailableStatus VARCHAR(10) DEFAULT 'yes'
   );

   -- Booking table
   CREATE TABLE booking_details (
       bookingID INT AUTO_INCREMENT PRIMARY KEY,
       userID INT NOT NULL,
       vehicleID INT NOT NULL,
       purchasedDate DATE NOT NULL,
       no_of_Days INT NOT NULL,
       bookedPrice FLOAT NOT NULL,
       vehicle_return_status VARCHAR(10) DEFAULT 'no',
       quantity INT NOT NULL,
       FOREIGN KEY (userID) REFERENCES user_details(userID),
       FOREIGN KEY (vehicleID) REFERENCES vehicle_details(vehicleID)
   );

   -- Discount table
   CREATE TABLE discount (
       days INT NOT NULL,
       no_of_vehicle INT NOT NULL,
       discount INT NOT NULL,
       PRIMARY KEY (days, no_of_vehicle)
   );

   -- Feedback table
   CREATE TABLE feedback (
       userID INT NOT NULL,
       vehicleID INT NOT NULL,
       feedback TEXT,
       PRIMARY KEY (userID, vehicleID),
       FOREIGN KEY (userID) REFERENCES user_details(userID),
       FOREIGN KEY (vehicleID) REFERENCES vehicle_details(vehicleID)
   );
   ```

3. **Insert Sample Admin**:
   ```sql
   INSERT INTO admin_details (adminName, adminPassword) 
   VALUES ('admin', 'admin123');
   ```

### Application Configuration

1. **Update Database Connection** (`src/main/webapp/META-INF/context.xml`):
   ```xml
   <Resource name="jdbc/MyDB" 
            auth="Container"
            type="javax.sql.DataSource" 
            maxActive="100" 
            maxIdle="30"
            maxWait="1000" 
            username="root" 
            password="your_mysql_password"
            driverClassName="com.mysql.cj.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/vehicle_rent_application_db"/>
   ```

2. **Configure Tomcat Server**:
   - Add the project as a Dynamic Web Project in Eclipse
   - Configure Tomcat server
   - Set the context path

3. **Build Project**:
   - Clean and build the project
   - Ensure all JAR files in `WEB-INF/lib` are on the classpath

4. **Deploy and Run**:
   - Deploy the application to Tomcat
   - Start the Tomcat server
   - Access the application at: `http://localhost:8080/ParaLokesh_VehicleRentApplication/`

## 📖 Usage

### For Administrators

1. **Login**: Navigate to Admin Login page
   - Username: `admin` (or as configured in database)
   - Password: `admin123` (or as configured)

2. **Manage System**:
   - View and manage customers
   - Add/update vehicles
   - Modify vehicle availability
   - Manage discount rules
   - View all bookings and feedback

### For Customers

1. **Register**: Create a new account with username, password, city, email, and phone number

2. **Login**: Use registered credentials

3. **Book Vehicles**:
   - Browse available vehicles
   - Select vehicle, booking date, number of days, and quantity
   - System automatically calculates discount
   - Confirm booking

4. **Manage Bookings**:
   - View all personal bookings
   - Cancel bookings if needed

5. **Submit Feedback**: Provide feedback for rented vehicles

## 🔐 Security Features

- Password-based authentication for both admin and users
- Session management for user state
- Input validation on registration and booking
- SQL injection prevention through PreparedStatement usage
- Connection pooling for database security and performance

## 📝 Logging

The application uses **Apache Log4j** for logging:
- Configuration file: `src/main/java/log4j.properties`
- Logs application events, errors, and debugging information
- Helps in troubleshooting and monitoring

## 🎨 UI/UX Features

- Responsive web design with CSS styling
- Separate interfaces for admin and customer
- User-friendly navigation
- Error handling and validation messages
- Success/error feedback to users

## 🔄 Future Enhancements

Potential improvements:
- Payment gateway integration
- Email notifications for bookings
- Advanced search and filtering
- Vehicle image upload
- Rating system for vehicles
- Report generation
- Multi-language support
- RESTful API development

## 📄 License

This project appears to be a case study/training project. Please check with the project owner for licensing information.

## 👤 Author

**Lokesh P**
- Developed as part of a final case study project

## 📞 Support

For issues or questions, please refer to the project documentation or contact the development team.

---

**Note**: This README is generated based on the project structure and code analysis. Ensure all database configurations and dependencies are properly set up before running the application.

