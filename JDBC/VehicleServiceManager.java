import java.sql.*;
import java.util.Scanner;

public class VehicleServiceManager {

    static final String URL = "jdbc:mysql://localhost:3306/serviceDB";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Vehicle");
                System.out.println("2. View Pending Vehicles");
                System.out.println("3. Update Status to Completed");
                System.out.println("4. Delete Vehicle");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addVehicle(con, sc);
                        break;
                    case 2:
                        viewVehicles(con);
                        break;
                    case 3:
                        updateStatus(con, sc);
                        break;
                    case 4:
                        deleteVehicle(con, sc);
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

    static void addVehicle(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter Registration No: ");
        String regNo = sc.next();
        sc.nextLine();

        System.out.print("Enter Owner Name: ");
        String owner = sc.nextLine();

        System.out.print("Enter Status: ");
        String status = sc.nextLine();

        String sql = "INSERT INTO vehicles VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, regNo);
        ps.setString(2, owner);
        ps.setString(3, status);

        ps.executeUpdate();
        System.out.println("Vehicle Added!");
    }

    static void viewVehicles(Connection con) throws Exception {
        String sql = "SELECT * FROM vehicles WHERE status='Pending'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(
                rs.getString("regNo") + " | " +
                rs.getString("owner") + " | " +
                rs.getString("status")
            );
        }
    }

    static void updateStatus(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter Registration No: ");
        String regNo = sc.next();

        String sql = "UPDATE vehicles SET status='Completed' WHERE regNo=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, regNo);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Status Updated!");
        } else {
            System.out.println("Vehicle Not Found!");
        }
    }

    static void deleteVehicle(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter Registration No to delete: ");
        String regNo = sc.next();

        String sql = "DELETE FROM vehicles WHERE regNo=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, regNo);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Vehicle Deleted!");
        } else {
            System.out.println("Vehicle Not Found!");
        }
    }
}