class Course {
    // Instance Variables
    String courseName;
    int duration; // in weeks or months
    double fee;

    // Class Variable (common for all courses)
    static String instituteName = "ABC Institute";

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance Method to display course details
    public void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration);
        System.out.println("Fee: " + fee);
        System.out.println();
    }

    // Class Method to update institute name
    public static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println("Institute Name Updated to: " + instituteName);
    }
}

public class CourseManagement {
    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 6, 15000);
        Course c2 = new Course("Python Programming", 4, 12000);

        System.out.println("Course Details Before Updating Institute Name:");
        c1.displayCourseDetails();
        c2.displayCourseDetails();

        // Updating institute name for all courses (class method)
        Course.updateInstituteName("XYZ Institute");

        System.out.println("\nCourse Details After Updating Institute Name:");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
