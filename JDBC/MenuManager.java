import java.sql.*;
import java.util.Scanner;

public class MenuManager {

    static final String URL = "jdbc:mysql://localhost:3306/restaurantDB";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Item");
                System.out.println("2. View Items (<200)");
                System.out.println("3. Update Price");
                System.out.println("4. Delete Item");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addItem(con, sc);
                        break;
                    case 2:
                        viewItems(con);
                        break;
                    case 3:
                        updatePrice(con, sc);
                        break;
                    case 4:
                        deleteItem(con, sc);
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

    static void addItem(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        String sql = "INSERT INTO menu VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setDouble(3, price);

        ps.executeUpdate();
        System.out.println("Item Added!");
    }

    static void viewItems(Connection con) throws Exception {
        String sql = "SELECT * FROM menu WHERE price < 200";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("itemName") + " | " +
                rs.getDouble("price")
            );
        }
    }

    static void updatePrice(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Price: ");
        double price = sc.nextDouble();

        String sql = "UPDATE menu SET price=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, price);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Price Updated!");
        } else {
            System.out.println("Item Not Found!");
        }
    }

    static void deleteItem(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM menu WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Item Deleted!");
        } else {
            System.out.println("Item Not Found!");
        }
    }
}