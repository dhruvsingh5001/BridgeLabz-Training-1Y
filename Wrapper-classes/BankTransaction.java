public class BankTransaction {

    public static double getRemainingLimit(Double limit, double usedAmount) {
        if (limit == null) {
            return 0.0;
        }
        return limit - usedAmount;
    }

    public static void main(String[] args) {
        Double limit1 = 1000.0;
        double used1 = 300.0;

        Double limit2 = null;
        double used2 = 200.0;

        System.out.println(getRemainingLimit(limit1, used1));
        System.out.println(getRemainingLimit(limit2, used2));
    }
}