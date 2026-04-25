import java.sql.*;
import java.util.Scanner;

public class BankManager {

    static final String URL = "jdbc:mysql://localhost:3306/bankDB";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Account");
                System.out.println("2. View Accounts (>10000)");
                System.out.println("3. Deposit/Withdraw");
                System.out.println("4. Delete Account");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addAccount(con, sc);
                        break;
                    case 2:
                        viewAccounts(con);
                        break;
                    case 3:
                        updateBalance(con, sc);
                        break;
                    case 4:
                        deleteAccount(con, sc);
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

    static void addAccount(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter Acc No: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Balance: ");
        double balance = sc.nextDouble();

        String sql = "INSERT INTO accounts VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, accNo);
        ps.setString(2, name);
        ps.setDouble(3, balance);

        ps.executeUpdate();
        System.out.println("Account Added!");
    }

    static void viewAccounts(Connection con) throws Exception {
        String sql = "SELECT * FROM accounts WHERE balance > 10000";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(
                rs.getInt("accNo") + " | " +
                rs.getString("name") + " | " +
                rs.getDouble("balance")
            );
        }
    }

    static void updateBalance(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter Acc No: ");
        int accNo = sc.nextInt();

        System.out.print("1. Deposit  2. Withdraw: ");
        int type = sc.nextInt();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        String sql = "SELECT balance FROM accounts WHERE accNo=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, accNo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            double balance = rs.getDouble("balance");

            if (type == 1) {
                balance += amount;
            } else {
                if (balance >= amount) {
                    balance -= amount;
                } else {
                    System.out.println("Insufficient Balance!");
                    return;
                }
            }

            String update = "UPDATE accounts SET balance=? WHERE accNo=?";
            PreparedStatement ps2 = con.prepareStatement(update);
            ps2.setDouble(1, balance);
            ps2.setInt(2, accNo);

            ps2.executeUpdate();
            System.out.println("Balance Updated!");
        } else {
            System.out.println("Account Not Found!");
        }
    }

    static void deleteAccount(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter Acc No to delete: ");
        int accNo = sc.nextInt();

        String sql = "DELETE FROM accounts WHERE accNo=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, accNo);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Account Deleted!");
        } else {
            System.out.println("Account Not Found!");
        }
    }
}