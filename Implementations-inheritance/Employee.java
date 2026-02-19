class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary + ", Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary + ", Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    int duration; // in months

    Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary + ", Duration: " + duration + " months");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 101, 90000, 5);
        Employee developer = new Developer("Bob", 102, 80000, "Java");
        Employee intern = new Intern("Charlie", 103, 20000, 6);

        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
}
