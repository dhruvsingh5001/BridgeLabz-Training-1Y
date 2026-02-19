class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay;

    // Default Constructor
    public CarRental() {
        customerName = "Customer";
        carModel = "Standard";
        rentalDays = 1;
        costPerDay = 1000.0;
    }

    // Parameterized Constructor
    public CarRental(String customerName, String carModel, int rentalDays, double costPerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.costPerDay = costPerDay;
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    // Method to display rental details
    public void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Cost per Day: " + costPerDay);
        System.out.println("Total Rental Cost: " + calculateTotalCost());
    }
}

public class CarRentalTest {
    public static void main(String[] args) {
        // Using Default Constructor
        CarRental rental1 = new CarRental();
        System.out.println("Rental 1 (Default Constructor):");
        rental1.displayDetails();

        // Using Parameterized Constructor
        CarRental rental2 = new CarRental("Aryan", "SUV", 5, 1500.0);
        System.out.println("\nRental 2 (Parameterized Constructor):");
        rental2.displayDetails();
    }
}
