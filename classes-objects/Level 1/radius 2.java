class Circle {
    double radius;

    // Default Constructor (sets default radius)
    public Circle() {
        this(1.0); // constructor chaining
    }

    // Parameterized Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }
}

public class CircleTest {
    public static void main(String[] args) {
        // Using default constructor
        Circle c1 = new Circle();
        System.out.println("Circle 1 (Default Radius):");
        c1.displayDetails();

        // Using parameterized constructor
        Circle c2 = new Circle(5.0);
        System.out.println("\nCircle 2 (User-Provided Radius):");
        c2.displayDetails();
    }
}
