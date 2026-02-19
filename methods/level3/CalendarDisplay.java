import java.util.*;

public class CalendarDisplay {

    static String getMonthName(int m) {
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return months[m - 1];
    }

    static boolean isLeapYear(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }

    static int getDaysInMonth(int m, int y) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (m == 2 && isLeapYear(y)) return 29;
        return days[m - 1];
    }

    static int getFirstDay(int m, int y) {
        int d = 1;
        if (m < 3) {
            m += 12;
            y--;
        }
        int k = y % 100;
        int j = y / 100;
        int f = d + (13 * (m + 1)) / 5 + k + k / 4 + j / 4 + 5 * j;
        return ((f % 7) + 6) % 7;
    }

    static void printCalendar(int m, int y) {
        System.out.println("\n  " + getMonthName(m) + " " + y);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int firstDay = getFirstDay(m, y);
        int days = getDaysInMonth(m, y);
        for (int i = 0; i < firstDay; i++) System.out.print("   ");
        for (int d = 1; d <= days; d++) {
            System.out.printf("%2d ", d);
            if ((d + firstDay) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int year = sc.nextInt();
        printCalendar(month, year);
    }
}
