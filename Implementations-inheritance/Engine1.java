class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Vehicle {
    private String model;
    private Engine engine;

    Vehicle(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    void startVehicle() {
        System.out.println("Starting vehicle: " + model);
        engine.start();
    }
}

class SportsVehicle {
    private Vehicle vehicle;

    SportsVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    void boost() {
        System.out.println("Activating turbo boost!");
        vehicle.startVehicle();
    }
}

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Vehicle car = new Vehicle("Sedan", engine);
        car.startVehicle();

        SportsVehicle sportsCar = new SportsVehicle(new Vehicle("Sports Car", engine));
        sportsCar.boost();
    }
}
