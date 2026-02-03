class Student {

    // Instance variables
    int id;
    String name;
    int age;

    // Method to display student details
    void displayDetails() {
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        System.out.println("Student Age  : " + age);
    }

    

    // Main method
    public static void main(String[] args) {

        // Object creation
        Student s1 = new Student();

        // Assigning values to instance variables
        s1.id = 101;
        s1.name = "Shivam";
        s1.age = 20;

        // Method calls
        s1.displayDetails();
       
    }
}
