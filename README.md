# ElevateLAbs_Task7
 Java JDBC Employee Input Application
This is a simple Java console application that uses JDBC (Java Database Connectivity) to connect to a MySQL database and perform employee data entry through keyboard input.

 Features
Connects to a MySQL database using JDBC

Takes employee details (Name, Department, Salary) via keyboard

Allows entering multiple employees in one session

Displays all employee records after insertion

 Tools & Technologies
Java (JDK 8 or higher)

MySQL Database

JDBC API

VS Code / IntelliJ / Eclipse

MySQL Connector/J (JDBC driver)

 How to Run
1.  Set Up MySQL Database
Run the following SQL commands to create the database and table:

sql
Copy
Edit
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(50),
    salary DOUBLE
);
2. Add JDBC Driver
Download the MySQL JDBC driver from:
https://dev.mysql.com/downloads/connector/j/

Add the JAR file to your project's classpath.

3. Update Database Credentials
In the Java file, replace the database connection variables with your credentials:

java
Copy
Edit
String url = "jdbc:mysql://localhost:3306/employee_db";
String user = "root";
String password = "your_password";
4.  Compile and Run
Compile:

javac EmployeeInputApp.java

java EmployeeInputApp


✅ Connected to the database!

Enter employee details:
Name: Pandu
Department: IT
Salary: 60000
✅ Employee added successfully!
Do you want to add another employee? (yes/no): yes

Name: Pooja
Department: Pharmasist
Salary: 50000
✅ Employee added successfully!
Do you want to add another employee? (yes/no): no

📋 All Employees in Database:
ID: 1 | Name: Alice | Dept: IT | Salary: 60000.00
ID: 2 | Name: Bob   | Dept: HR | Salary: 50000.00
📚 Concepts Demonstrated
Java JDBC connection setup

Use of PreparedStatement for secure insertions

Reading input using Scanner

Looping and decision-making

Reading results using ResultSet

