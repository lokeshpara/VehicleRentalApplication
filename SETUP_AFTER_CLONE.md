# Setup Instructions After Cloning from GitHub

If you've cloned this repository from GitHub, follow these steps to set up the application.

## 🔧 Configuration Steps

### 1. Database Configuration

The `context.xml` file contains placeholder values. Update it with your actual database credentials:

**File:** `src/main/webapp/META-INF/context.xml`

```xml
<Resource name="jdbc/MyDB" 
         auth="Container"
         type="javax.sql.DataSource" 
         maxActive="100" 
         maxIdle="30"
         maxWait="1000" 
         username="YOUR_DB_USERNAME"      <!-- Replace with your MySQL username -->
         password="YOUR_DB_PASSWORD"       <!-- Replace with your MySQL password -->
         driverClassName="com.mysql.cj.jdbc.Driver"
         url="jdbc:mysql://localhost:3306/vehicle_rent_application_db"/>
```

**Example:**
```xml
username="root" 
password="your_actual_password"
```

### 2. Create Database

Run the SQL scripts to create the database and tables. See the **Database Setup** section in `README.md` for complete SQL scripts.

### 3. Build the Project

1. Import the project into Eclipse (or your preferred IDE)
2. Configure Tomcat server
3. Build the project (clean and build)

### 4. Deploy and Run

1. Deploy to Tomcat
2. Start the server
3. Access: `http://localhost:8080/ParaLokesh_VehicleRentApplication/`

## 📝 Notes

- The template file `context.xml.template` shows the structure but should not be used directly
- Always use `context.xml` for actual deployment
- Never commit `context.xml` with real credentials to Git

## 🔐 Security Reminder

For production deployments:
- Use environment variables for sensitive data
- Use connection pooling with encrypted credentials
- Never expose database credentials in version control

