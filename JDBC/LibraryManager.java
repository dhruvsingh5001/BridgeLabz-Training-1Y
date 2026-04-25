import java.sql.*;

public class LibraryManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            addBook(con, 1, "Java Basics", "James Gosling", "Available");
            addBook(con, 2, "Data Structures", "Mark Allen", "Available");

            showAvailableBooks(con);
            issueBook(con, 1);
            deleteBook(con, 2);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addBook(Connection con, int id, String title, String author, String status) throws SQLException {
        String query = "INSERT INTO books VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, title);
        ps.setString(3, author);
        ps.setString(4, status);
        ps.executeUpdate();
    }

    public static void showAvailableBooks(Connection con) throws SQLException {
        String query = "SELECT * FROM books WHERE status = 'Available'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " " +
                rs.getString("title") + " " +
                rs.getString("author") + " " +
                rs.getString("status")
            );
        }
    }

    public static void issueBook(Connection con, int id) throws SQLException {
        String query = "UPDATE books SET status = 'Issued' WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static void deleteBook(Connection con, int id) throws SQLException {
        String query = "DELETE FROM books WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}