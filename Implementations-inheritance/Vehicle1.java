class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed);
    }
}

class Car extends Vehicle {
    int seatCapacity;

    Car(int maxSpeed, String model, int seatCapacity) {
        super(maxSpeed, model);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("Car Model: " + model + ", Max Speed: " + maxSpeed + ", Seats: " + seatCapacity);
    }
}

class Motorcycle extends Vehicle {
    boolean hasCarrier;

    Motorcycle(int maxSpeed, String model, boolean hasCarrier) {
        super(maxSpeed, model);
        this.hasCarrier = hasCarrier;
    }

    @Override
    void displayInfo() {
        System.out.println("Motorcycle Model: " + model + ", Max Speed: " + maxSpeed + ", Has Carrier: " + hasCarrier);
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car(180, "Honda Civic", 5);
        Vehicle bike = new Motorcycle(150, "Yamaha R15", true);

        car.displayInfo();
        bike.displayInfo();
    }
}
