import java.sql.*;

public class ProductInventory {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            addProduct(con, 1, "Pen", 20);
            addProduct(con, 2, "Notebook", 5);
            addProduct(con, 3, "Pencil", 8);

            getLowStock(con);
            updateQuantity(con, 2, 15);
            deleteProduct(con, 3);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addProduct(Connection con, int pid, String pname, int qty) throws SQLException {
        String query = "INSERT INTO product VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, pid);
        ps.setString(2, pname);
        ps.setInt(3, qty);
        ps.executeUpdate();
    }

    public static void getLowStock(Connection con) throws SQLException {
        String query = "SELECT * FROM product WHERE qty < 10";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println(
                rs.getInt("pid") + " " +
                rs.getString("pname") + " " +
                rs.getInt("qty")
            );
        }
    }

    public static void updateQuantity(Connection con, int pid, int newQty) throws SQLException {
        String query = "UPDATE product SET qty = ? WHERE pid = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, newQty);
        ps.setInt(2, pid);
        ps.executeUpdate();
    }

    public static void deleteProduct(Connection con, int pid) throws SQLException {
        String query = "DELETE FROM product WHERE pid = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, pid);
        ps.executeUpdate();
    }
}