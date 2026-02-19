interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    String name;

    Duck(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying.");
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming.");
    }
}

public class Main {
    public static void main(String[] args) {
        Duck daffy = new Duck("Daffy");
        daffy.fly();
        daffy.swim();
    }
}
