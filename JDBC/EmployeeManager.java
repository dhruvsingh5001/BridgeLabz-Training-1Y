import java.sql.*;

public class EmployeeManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            addEmployee(con, 1, "Rahul", 25000);
            addEmployee(con, 2, "Aman", 40000);
            addEmployee(con, 3, "Priya", 12000);

            getHighSalaryEmployees(con);
            updateSalary(con, 1);
            deleteLowSalaryEmployees(con);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addEmployee(Connection con, int id, String name, double salary) throws SQLException {
        String query = "INSERT INTO employee VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setDouble(3, salary);
        ps.executeUpdate();
    }

    public static void getHighSalaryEmployees(Connection con) throws SQLException {
        String query = "SELECT * FROM employee WHERE salary > 30000";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " " +
                rs.getString("name") + " " +
                rs.getDouble("salary")
            );
        }
    }

    public static void updateSalary(Connection con, int empId) throws SQLException {
        String query = "UPDATE employee SET salary = salary + (salary * 0.10) WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, empId);
        ps.executeUpdate();
    }

    public static void deleteLowSalaryEmployees(Connection con) throws SQLException {
        String query = "DELETE FROM employee WHERE salary < 15000";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(query);
    }
}