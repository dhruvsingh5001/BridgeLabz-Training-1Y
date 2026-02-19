class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 5000.0;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
        System.out.println();
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

public class VehicleRegistration {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Aryan", "Car");
        Vehicle v2 = new Vehicle("Rahul", "Bike");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(7000.0);

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
