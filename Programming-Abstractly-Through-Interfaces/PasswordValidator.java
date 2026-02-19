interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        if (password.length() < 8) return false;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}

public class PasswordValidator {
    public static void main(String[] args) {
        String password = "Test@123";

        if (SecurityUtils.isStrongPassword(password))
            System.out.println("Strong Password");
        else
            System.out.println("Weak Password");
    }
}
