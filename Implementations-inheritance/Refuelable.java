interface Refuelable {
    void refuel();
}

class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println("Charging " + model + " with battery capacity: " + batteryCapacity + " kWh");
    }

    @Override
    void displayInfo() {
        System.out.println("Electric Vehicle -> Model: " + model + ", Max Speed: " + maxSpeed + " km/h, Battery: " + batteryCapacity + " kWh");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelTankCapacity;

    PetrolVehicle(int maxSpeed, String model, int fuelTankCapacity) {
        super(maxSpeed, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public void refuel() {
        System.out.println("Refueling " + model + " with tank capacity: " + fuelTankCapacity + " liters");
    }

    @Override
    void displayInfo() {
        System.out.println("Petrol Vehicle -> Model: " + model + ", Max Speed: " + maxSpeed + " km/h, Fuel Tank: " + fuelTankCapacity + " liters");
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(150, "Tesla Model 3", 75);
        PetrolVehicle pv = new PetrolVehicle(180, "Honda Civic", 50);

        ev.displayInfo();
        ev.charge();

        pv.displayInfo();
        pv.refuel();
    }
}
