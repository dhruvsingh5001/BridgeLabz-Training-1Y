import java.util.*;

class Vehicle {
    String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Truck extends Vehicle {
    public Truck(String name) {
        super(name);
    }
}

class Bike extends Vehicle {
    public Bike(String name) {
        super(name);
    }
}

class FleetManager<T extends Vehicle> {
    private List<T> fleet = new ArrayList<>();

    public void addVehicle(T vehicle) {
        fleet.add(vehicle);
    }

    public void showFleet() {
        for (T v : fleet) {
            System.out.println(v);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FleetManager<Truck> truckFleet = new FleetManager<>();
        truckFleet.addVehicle(new Truck("Volvo Truck"));
        truckFleet.addVehicle(new Truck("Tata Truck"));
        truckFleet.showFleet();

        FleetManager<Bike> bikeFleet = new FleetManager<>();
        bikeFleet.addVehicle(new Bike("Yamaha"));
        bikeFleet.addVehicle(new Bike("Honda"));
        bikeFleet.showFleet();
    }
}