import java.util.ArrayList;
import java.util.List;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle implements Insurable {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        if (rentalRate > 0) {
            this.rentalRate = rentalRate;
        }
    }

    private String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public abstract double calculateRentalCost(int days);

    public void displayVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + type);
        System.out.println("Rental Rate per Day: " + rentalRate);
    }

    protected String maskedPolicyNumber() {
        return "Policy No: XXXX" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 2);
    }
}

class Car extends Vehicle {

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (10%) - " + maskedPolicyNumber();
    }
}

class Bike extends Vehicle {

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance (5%) - " + maskedPolicyNumber();
    }
}

class Truck extends Vehicle {

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 500;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance (15%) - " + maskedPolicyNumber();
    }
}

public class VehicleRentalSystem {

    public static void processRentals(List<Vehicle> vehicles, int days) {
        for (Vehicle v : vehicles) {
            v.displayVehicleDetails();

            double rentalCost = v.calculateRentalCost(days);
            double insuranceCost = v.calculateInsurance();

            System.out.println("Rental Cost for " + days + " days: " + rentalCost);
            System.out.println(v.getInsuranceDetails());
            System.out.println("Insurance Cost: " + insuranceCost);
            System.out.println("Total Cost: " + (rentalCost + insuranceCost));
            System.out.println("-----------------------------------");
        }
    }

    public static void main(String[] args) {

        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(new Car("CAR123", 2000, "POL9876"));
        vehicleList.add(new Bike("BIKE456", 800, "POL1234"));
        vehicleList.add(new Truck("TRK789", 5000, "POL5678"));

        int rentalDays = 3;

        System.out.println("=== Vehicle Rental System ===\n");

        processRentals(vehicleList, rentalDays);
    }
}
