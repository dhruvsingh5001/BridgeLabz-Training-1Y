class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayRole() {
        System.out.println("Generic Person");
    }
}

class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    void displayRole() {
        System.out.println("Teacher -> Name: " + name + ", Age: " + age + ", Subject: " + subject);
    }
}

class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    void displayRole() {
        System.out.println("Student -> Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}

class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    void displayRole() {
        System.out.println("Staff -> Name: " + name + ", Age: " + age + ", Department: " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        Person teacher = new Teacher("Alice", 35, "Mathematics");
        Person student = new Student("Bob", 16, "10th Grade");
        Person staff = new Staff("Charlie", 40, "Administration");

        teacher.displayRole();
        student.displayRole();
        staff.displayRole();
    }
}
