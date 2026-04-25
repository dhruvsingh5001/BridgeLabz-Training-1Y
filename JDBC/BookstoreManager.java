import java.sql.*;
import java.util.Scanner;

public class BookstoreManager {

    static final String URL = "jdbc:mysql://localhost:3306/bookstoreDB";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Sale");
                System.out.println("2. View Sales (Quantity > 1)");
                System.out.println("3. Update Quantity");
                System.out.println("4. Delete Sale");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addSale(con, sc);
                        break;
                    case 2:
                        viewSales(con);
                        break;
                    case 3:
                        updateSale(con, sc);
                        break;
                    case 4:
                        deleteSale(con, sc);
                        break;
                    case 5:
                        con.close();
                        System.exit(0);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addSale(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        String sql = "INSERT INTO sales VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, quantity);
        ps.setDouble(4, price);

        ps.executeUpdate();
        System.out.println("Sale Added!");
    }

    static void viewSales(Connection con) throws Exception {
        String sql = "SELECT * FROM sales WHERE quantity > 1";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("bookName") + " | " +
                rs.getInt("quantity") + " | " +
                rs.getDouble("price")
            );
        }
    }

    static void updateSale(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Quantity: ");
        int quantity = sc.nextInt();

        String sql = "UPDATE sales SET quantity=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, quantity);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Updated Successfully!");
        } else {
            System.out.println("Record Not Found!");
        }
    }

    static void deleteSale(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM sales WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Sale Deleted!");
        } else {
            System.out.println("Record Not Found!");
        }
    }
}