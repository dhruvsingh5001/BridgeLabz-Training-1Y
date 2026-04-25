import java.sql.*;
import java.util.Scanner;

public class GymManager {

    static final String URL = "jdbc:mysql://localhost:3306/gymDB";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Member");
                System.out.println("2. View Premium Members");
                System.out.println("3. Extend Membership");
                System.out.println("4. Delete Member");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addMember(con, sc);
                        break;
                    case 2:
                        viewMembers(con);
                        break;
                    case 3:
                        updateMonths(con, sc);
                        break;
                    case 4:
                        deleteMember(con, sc);
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

    static void addMember(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Membership Type: ");
        String type = sc.nextLine();

        System.out.print("Enter Months: ");
        int months = sc.nextInt();

        String sql = "INSERT INTO members VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, type);
        ps.setInt(4, months);

        ps.executeUpdate();
        System.out.println("Member Added!");
    }

    static void viewMembers(Connection con) throws Exception {
        String sql = "SELECT * FROM members WHERE type='Premium'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("type") + " | " +
                rs.getInt("months")
            );
        }
    }

    static void updateMonths(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Months to Extend: ");
        int addMonths = sc.nextInt();

        String sql = "UPDATE members SET months = months + ? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, addMonths);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Membership Extended!");
        } else {
            System.out.println("Member Not Found!");
        }
    }

    static void deleteMember(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM members WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Member Deleted!");
        } else {
            System.out.println("Member Not Found!");
        }
    }
}