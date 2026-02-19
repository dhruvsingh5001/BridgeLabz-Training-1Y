class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
    }
}

class Student extends Person {
    int grade;

    Student(String name, int grade) {
        super(name);
        this.grade = grade;
    }

    @Override
    void displayInfo() {
        System.out.println("Name: " + name + ", Grade: " + grade);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Alice", 10);
        s.displayInfo();
    }
}
