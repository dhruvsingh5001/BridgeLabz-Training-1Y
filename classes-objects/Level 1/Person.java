class Person {
    String name;
    int age;

    // Parameterized Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy Constructor
    public Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class PersonTest {
    public static void main(String[] args) {
        // Original object
        Person p1 = new Person("Aryan", 20);

        // Cloning using copy constructor
        Person p2 = new Person(p1);

        System.out.println("Original Person Details:");
        p1.displayDetails();

        System.out.println("\nCloned Person Details:");
        p2.displayDetails();
    }
}
