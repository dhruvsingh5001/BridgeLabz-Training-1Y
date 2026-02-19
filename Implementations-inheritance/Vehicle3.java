class Vehicle {
    private int maxSpeed;
    private String model;

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getModel() {
        return model;
    }

    void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed);
    }
}

class Car extends Vehicle {
    private int seatCapacity;

    Car(int maxSpeed, String model, int seatCapacity) {
        super(maxSpeed, model);
        this.seatCapacity = seatCapacity;
    }

    void displayCarInfo() {
        displayInfo();
        System.out.println("Seats: " + seatCapacity);
    }
}

class Motorcycle extends Vehicle {
    private boolean hasCarrier;

    Motorcycle(int maxSpeed, String model, boolean hasCarrier) {
        super(maxSpeed, model);
        this.hasCarrier = hasCarrier;
    }

    void displayMotorcycleInfo() {
        displayInfo();
        System.out.println("Has Carrier: " + hasCarrier);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car(180, "Honda Civic", 5);
        Motorcycle bike = new Motorcycle(150, "Yamaha R15", true);

        car.displayCarInfo();
        bike.displayMotorcycleInfo();
    }
}
