import java.util.HashSet;

public class OTPGenerator {
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    public static boolean areUnique(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otpArray = new int[10];

        for (int i = 0; i < 10; i++) {
            otpArray[i] = generateOTP();
        }

        for (int otp : otpArray) {
            System.out.println(otp);
        }

        if (areUnique(otpArray)) {
            System.out.println("All OTPs are unique");
        } else {
            System.out.println("Duplicate OTP found");
        }
    }
}
