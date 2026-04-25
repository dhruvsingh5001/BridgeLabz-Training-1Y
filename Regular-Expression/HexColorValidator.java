public class HexColorValidator {
    public static void main(String[] args) {
        String color = "#FFA500";
        if (color.matches("^#[0-9A-Fa-f]{6}$")) {
            System.out.println("Valid Hex Color");
        } else {
            System.out.println("Invalid Hex Color");
        }
    }
}