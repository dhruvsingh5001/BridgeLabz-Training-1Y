import java.sql.*;
import java.util.Scanner;

public class MovieManager {

    static final String URL = "jdbc:mysql://localhost:3306/movieDB";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Movie");
                System.out.println("2. View Available Movies");
                System.out.println("3. Book Ticket");
                System.out.println("4. Delete Movie");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addMovie(con, sc);
                        break;
                    case 2:
                        viewMovies(con);
                        break;
                    case 3:
                        bookTicket(con, sc);
                        break;
                    case 4:
                        deleteMovie(con, sc);
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

    static void addMovie(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter Movie ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Movie Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Seats: ");
        int seats = sc.nextInt();

        String sql = "INSERT INTO movies VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, seats);

        ps.executeUpdate();
        System.out.println("Movie Added!");
    }

    static void viewMovies(Connection con) throws Exception {
        String sql = "SELECT * FROM movies WHERE seats > 0";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("name") + " | " +
                rs.getInt("seats")
            );
        }
    }

    static void bookTicket(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter Movie ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Number of Tickets: ");
        int tickets = sc.nextInt();

        String sql = "SELECT seats FROM movies WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int seats = rs.getInt("seats");

            if (seats >= tickets) {
                seats -= tickets;

                String update = "UPDATE movies SET seats=? WHERE id=?";
                PreparedStatement ps2 = con.prepareStatement(update);
                ps2.setInt(1, seats);
                ps2.setInt(2, id);

                ps2.executeUpdate();
                System.out.println("Booking Successful!");
            } else {
                System.out.println("Not enough seats!");
            }
        } else {
            System.out.println("Movie Not Found!");
        }
    }

    static void deleteMovie(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter Movie ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM movies WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Movie Deleted!");
        } else {
            System.out.println("Movie Not Found!");
        }
    }
}