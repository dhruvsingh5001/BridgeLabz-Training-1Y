import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateFormatterUtil {

    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

public class InvoiceDateFormat {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        String format1 = DateFormatterUtil.formatDate(today, "dd-MM-yyyy");
        String format2 = DateFormatterUtil.formatDate(today, "MMMM dd, yyyy");
        String format3 = DateFormatterUtil.formatDate(today, "yyyy/MM/dd");

        System.out.println(format1);
        System.out.println(format2);
        System.out.println(format3);
    }
}
