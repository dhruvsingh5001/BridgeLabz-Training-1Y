class Engine {
    String type;
    int horsepower;

    Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }

    void start() {
        System.out.println("Engine of type " + type + " with " + horsepower + " HP started.");
    }
}

class Car {
    String model;
    Engine engine;

    Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    void startCar() {
        System.out.println("Starting car: " + model);
        engine.start();
    }
}

public class Main {
    public static void main(String[] args) {
        Engine v6 = new Engine("V6", 300);
        Car mustang = new Car("Ford Mustang", v6);

        mustang.startCar();
    }
}
