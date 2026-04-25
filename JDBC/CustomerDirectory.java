import java.sql.*;

public class AllManagers {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            Statement stmt = con.createStatement();

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS employee (id INT, name VARCHAR(50), salary DOUBLE)");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS product (pid INT, pname VARCHAR(50), qty INT)");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS books (id INT, title VARCHAR(100), author VARCHAR(50), status VARCHAR(10))");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS customers (id INT, name VARCHAR(50), phone VARCHAR(15))");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS accounts (accNo INT, name VARCHAR(50), balance DOUBLE)");

            addEmployee(con, 1, "Rahul", 25000);
            addProduct(con, 1, "Pen", 20);
            addBook(con, 1, "Java", "James", "Available");
            addCustomer(con, 1, "Aman", "9876543210");
            addAccount(con, 101, "Ravi", 15000);

            getEmployees(con);
            getProducts(con);
            getBooks(con);
            getCustomers(con);
            getAccounts(con);

            updateEmployee(con, 1);
            updateProduct(con, 1, 50);
            issueBook(con, 1);
            updateCustomer(con, 1, "9999999999");
            deposit(con, 101, 5000);

            deleteEmployee(con);
            deleteProduct(con, 1);
            deleteBook(con, 1);
            deleteCustomer(con, 1);
            deleteAccount(con, 101);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addEmployee(Connection con, int id, String name, double salary) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO employee VALUES (?, ?, ?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setDouble(3, salary);
        ps.executeUpdate();
    }

    static void getEmployees(Connection con) throws SQLException {
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM employee WHERE salary > 30000");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3));
        }
    }

    static void updateEmployee(Connection con, int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE employee SET salary = salary + salary*0.10 WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    static void deleteEmployee(Connection con) throws SQLException {
        con.createStatement().executeUpdate("DELETE FROM employee WHERE salary < 15000");
    }

    static void addProduct(Connection con, int pid, String pname, int qty) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO product VALUES (?, ?, ?)");
        ps.setInt(1, pid);
        ps.setString(2, pname);
        ps.setInt(3, qty);
        ps.executeUpdate();
    }

    static void getProducts(Connection con) throws SQLException {
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM product WHERE qty < 10");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
        }
    }

    static void updateProduct(Connection con, int pid, int qty) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE product SET qty=? WHERE pid=?");
        ps.setInt(1, qty);
        ps.setInt(2, pid);
        ps.executeUpdate();
    }

    static void deleteProduct(Connection con, int pid) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM product WHERE pid=?");
        ps.setInt(1, pid);
        ps.executeUpdate();
    }

    static void addBook(Connection con, int id, String title, String author, String status) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO books VALUES (?, ?, ?, ?)");
        ps.setInt(1, id);
        ps.setString(2, title);
        ps.setString(3, author);
        ps.setString(4, status);
        ps.executeUpdate();
    }

    static void getBooks(Connection con) throws SQLException {
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM books WHERE status='Available'");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
        }
    }

    static void issueBook(Connection con, int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE books SET status='Issued' WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    static void deleteBook(Connection con, int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM books WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    static void addCustomer(Connection con, int id, String name, String phone) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO customers VALUES (?, ?, ?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, phone);
        ps.executeUpdate();
    }

    static void getCustomers(Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM customers WHERE name LIKE ?");
        ps.setString(1, "A%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
    }

    static void updateCustomer(Connection con, int id, String phone) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE customers SET phone=? WHERE id=?");
        ps.setString(1, phone);
        ps.setInt(2, id);
        ps.executeUpdate();
    }

    static void deleteCustomer(Connection con, int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM customers WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    static void addAccount(Connection con, int accNo, String name, double balance) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO accounts VALUES (?, ?, ?)");
        ps.setInt(1, accNo);
        ps.setString(2, name);
        ps.setDouble(3, balance);
        ps.executeUpdate();
    }

    static void getAccounts(Connection con) throws SQLException {
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM accounts WHERE balance > 10000");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3));
        }
    }

    static void deposit(Connection con, int accNo, double amount) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE accounts SET balance=balance+? WHERE accNo=?");
        ps.setDouble(1, amount);
        ps.setInt(2, accNo);
        ps.executeUpdate();
    }

    static void withdraw(Connection con, int accNo, double amount) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE accounts SET balance=balance-? WHERE accNo=?");
        ps.setDouble(1, amount);
        ps.setInt(2, accNo);
        ps.executeUpdate();
    }

    static void deleteAccount(Connection con, int accNo) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM accounts WHERE accNo=?");
        ps.setInt(1, accNo);
        ps.executeUpdate();
    }
}