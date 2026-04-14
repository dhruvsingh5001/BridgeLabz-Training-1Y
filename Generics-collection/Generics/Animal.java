import java.util.*;

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class AnimalUtil {
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal a : animals) {
            System.out.println(a);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(new Dog("Tommy"), new Dog("Bruno"));
        List<Cat> cats = Arrays.asList(new Cat("Kitty"), new Cat("Misty"));

        AnimalUtil.printAnimals(dogs);
        AnimalUtil.printAnimals(cats);
    }
}