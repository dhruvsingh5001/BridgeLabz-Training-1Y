class Course {
    String courseName;
    int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayInfo() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration + " hours");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayInfo() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration + " hours, Platform: " + platform +
                           ", Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void displayInfo() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration + " hours, Platform: " + platform +
                           ", Recorded: " + isRecorded + ", Fee: $" + fee + ", Discount: $" + discount);
    }
}

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course("Math Basics", 40);
        OnlineCourse course2 = new OnlineCourse("Java Programming", 60, "Udemy", true);
        PaidOnlineCourse course3 = new PaidOnlineCourse("Full Stack Development", 120, "Coursera", false, 500, 50);

        course1.displayInfo();
        course2.displayInfo();
        course3.displayInfo();
    }
}
