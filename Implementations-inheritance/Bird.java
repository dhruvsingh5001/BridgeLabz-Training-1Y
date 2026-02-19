class Bird {
    void fly() {
        System.out.println("This bird can fly");
    }
}

class Sparrow extends Bird {
    @Override
    void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Ostrich extends Bird {
    @Override
    void fly() {
        System.out.println("Ostrich cannot fly");
    }
}

public class Main {
    public static void makeBirdFly(Bird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird ostrich = new Ostrich();

        makeBirdFly(sparrow);
        makeBirdFly(ostrich);
    }
}
