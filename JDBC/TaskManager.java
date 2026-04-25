import java.sql.*;
import java.util.Scanner;

public class TaskManager {

    static final String URL = "jdbc:mysql://localhost:3306/todoDB";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Task");
                System.out.println("2. View Pending Tasks");
                System.out.println("3. Mark Completed");
                System.out.println("4. Delete Completed Tasks");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addTask(con, sc);
                        break;
                    case 2:
                        viewTasks(con);
                        break;
                    case 3:
                        updateTask(con, sc);
                        break;
                    case 4:
                        deleteTasks(con);
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

    static void addTask(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Status: ");
        String status = sc.nextLine();

        String sql = "INSERT INTO tasks VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, title);
        ps.setString(3, status);

        ps.executeUpdate();
        System.out.println("Task Added!");
    }

    static void viewTasks(Connection con) throws Exception {
        String sql = "SELECT * FROM tasks WHERE status='Pending'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("title") + " | " +
                rs.getString("status")
            );
        }
    }

    static void updateTask(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        String sql = "UPDATE tasks SET status='Completed' WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Task Updated!");
        } else {
            System.out.println("Task Not Found!");
        }
    }

    static void deleteTasks(Connection con) throws Exception {
        String sql = "DELETE FROM tasks WHERE status='Completed'";
        Statement st = con.createStatement();

        int rows = st.executeUpdate(sql);

        if (rows > 0) {
            System.out.println("Completed Tasks Deleted!");
        } else {
            System.out.println("No Completed Tasks Found!");
        }
    }
}