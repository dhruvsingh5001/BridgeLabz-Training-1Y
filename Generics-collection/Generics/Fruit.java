class Fruit {
    String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Apple extends Fruit {
    public Apple(String name) {
        super(name);
    }
}

class Mango extends Fruit {
    public Mango(String name) {
        super(name);
    }
}

class FruitBox<T extends Fruit> {
    private java.util.ArrayList<T> fruits = new java.util.ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void display() {
        for (T f : fruits) {
            System.out.println(f);
        }
    }
}

class Car {
    String model;

    public Car(String model) {
        this.model = model;
    }
}

public class Main {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple("Red Apple"));
        appleBox.add(new Apple("Green Apple"));
        appleBox.display();

        FruitBox<Mango> mangoBox = new FruitBox<>();
        mangoBox.add(new Mango("Alphonso"));
        mangoBox.add(new Mango("Kesar"));
        mangoBox.display();

        // FruitBox<Car> carBox = new FruitBox<>(); // Compile-time error
    }
}