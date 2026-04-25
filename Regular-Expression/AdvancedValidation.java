public class AdvancedValidation {
    public static void main(String[] args) {
        String ip = "192.168.1.1";
        String card = "4123456789012345";

        if (ip.matches("^(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}$")) {
            System.out.println("Valid IP");
        } else {
            System.out.println("Invalid IP");
        }

        if (card.matches("^(4\\d{15}|5\\d{15})$")) {
            System.out.println("Valid Card");
        } else {
            System.out.println("Invalid Card");
        }
    }
}