interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    public void performDuties() {
        System.out.println("Chef " + name + " is cooking specialty: " + specialty);
    }
}

class Waiter extends Person implements Worker {
    int tableNumber;

    Waiter(String name, int id, int tableNumber) {
        super(name, id);
        this.tableNumber = tableNumber;
    }

    public void performDuties() {
        System.out.println("Waiter " + name + " is serving table number: " + tableNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        Worker chef = new Chef("Gordon", 101, "Italian Cuisine");
        Worker waiter = new Waiter("John", 201, 5);

        chef.performDuties();
        waiter.performDuties();
    }
}
