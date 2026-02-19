class Creature {
    void makeSound() {
        System.out.println("Some generic creature sound");
    }
}

class Wolf extends Creature {
    @Override
    void makeSound() {
        System.out.println("Howl Howl");
    }
}

class Lion extends Creature {
    @Override
    void makeSound() {
        System.out.println("Roar Roar");
    }
}

public class Main {
    public static void main(String[] args) {
        Creature wolf = new Wolf();
        Creature lion = new Lion();

        wolf.makeSound();
        lion.makeSound();

        Creature[] creatures = { new Wolf(), new Lion() };
        for (Creature c : creatures) {
            c.makeSound();
        }
    }
}
