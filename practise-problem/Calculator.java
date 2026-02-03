class Calculator {

    double a;
    double b;

    // Method for Addition
    void addition() {
        System.out.println("Addition = " + (a + b));
    }

    // Method for Subtraction
    void subtract() {
        System.out.println("Subtraction = " + (a - b));
    }

    // Method for Multiplication
    void multiplication() {
        System.out.println("Multiplication = " + (a * b));
    }

    // Method for Division
    void division() {
        if (b != 0) {
            System.out.println("Division = " + (a / b));
        } else {
            System.out.println("Division not possible");
        }
    }

    public static void main(String[] args) {

        // Object creation
        Calculator cal = new Calculator();

        // Assign values
        cal.a = 5;
        cal.b = 10;

        // Method calls
        cal.addition();
        cal.subtract();
        cal.multiplication();
        cal.division();
    }
}
