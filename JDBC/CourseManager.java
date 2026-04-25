import java.sql.*;
import java.util.Scanner;

public class CourseManager {

    static final String URL = "jdbc:mysql://localhost:3306/courseDB";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Enrollment");
                System.out.println("2. View Enrollments by Course");
                System.out.println("3. Update Course");
                System.out.println("4. Delete Enrollment");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addEnrollment(con, sc);
                        break;
                    case 2:
                        viewEnrollments(con, sc);
                        break;
                    case 3:
                        updateCourse(con, sc);
                        break;
                    case 4:
                        deleteEnrollment(con, sc);
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

    static void addEnrollment(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String student = sc.nextLine();

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        String sql = "INSERT INTO enrollments VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, student);
        ps.setString(3, course);

        ps.executeUpdate();
        System.out.println("Enrollment Added!");
    }

    static void viewEnrollments(Connection con, Scanner sc) throws Exception {
        sc.nextLine();
        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        String sql = "SELECT * FROM enrollments WHERE course=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, course);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("student") + " | " +
                rs.getString("course")
            );
        }
    }

    static void updateCourse(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Course: ");
        String course = sc.nextLine();

        String sql = "UPDATE enrollments SET course=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, course);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Updated Successfully!");
        } else {
            System.out.println("Record Not Found!");
        }
    }

    static void deleteEnrollment(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM enrollments WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Enrollment Deleted!");
        } else {
            System.out.println("Record Not Found!");
        }
    }
}