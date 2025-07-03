import java.sql.*;
import java.util.Scanner;

public class EmployeeInputApp {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee_db";
        String user = "root"; // replace with your DB username
        String password = "root"; // replace with your DB password

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("✅ Connected to the database!");

            String insertSQL = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);

            while (true) {
                System.out.println("\nEnter employee details:");

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Department: ");
                String department = scanner.nextLine();

                System.out.print("Salary: ");
                double salary = Double.parseDouble(scanner.nextLine());

                // Set parameters
                pstmt.setString(1, name);
                pstmt.setString(2, department);
                pstmt.setDouble(3, salary);

                // Execute insert
                pstmt.executeUpdate();
                System.out.println("✅ Employee added successfully!");

                // Ask user if they want to continue
                System.out.print("Do you want to add another employee? (yes/no): ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("yes")) {
                    break;
                }
            }

            // View all records
            System.out.println("\n📋 All Employees in Database:");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Dept: %s | Salary: %.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary"));
            }

            // Close resources
            rs.close();
            stmt.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
