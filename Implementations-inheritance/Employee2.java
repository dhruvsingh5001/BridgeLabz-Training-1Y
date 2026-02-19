class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    void work() {
        System.out.println(name + " is working on general tasks.");
    }
}

class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, String programmingLanguage) {
        super(name);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void work() {
        System.out.println(name + " is coding in " + programmingLanguage);
    }

    void attendMeeting() {
        System.out.println(name + " is attending a meeting.");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice");
        Developer dev = new Developer("Bob", "Java");

        emp.work();
        dev.work();
        dev.attendMeeting();
    }
}
