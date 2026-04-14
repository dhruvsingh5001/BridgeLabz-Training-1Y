import java.util.*;

abstract class CourseType {
    String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }
}

class Course<T extends CourseType> {
    String courseName;
    T type;

    public Course(String courseName, T type) {
        this.courseName = courseName;
        this.type = type;
    }

    public String toString() {
        return courseName + " - " + type;
    }
}

class CourseUtil {
    public static void displayCourses(List<? extends CourseType> types) {
        for (CourseType t : types) {
            System.out.println(t);
        }
    }

    public static <T extends CourseType> void displayCourseList(List<Course<T>> courses) {
        for (Course<T> c : courses) {
            System.out.println(c);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Course<ExamCourse>> examCourses = Arrays.asList(
                new Course<>("Math", new ExamCourse("Final Exam")),
                new Course<>("Physics", new ExamCourse("Mid + Final"))
        );

        List<Course<AssignmentCourse>> assignmentCourses = Arrays.asList(
                new Course<>("Java", new AssignmentCourse("Assignments")),
                new Course<>("DBMS", new AssignmentCourse("Projects"))
        );

        List<Course<ResearchCourse>> researchCourses = Arrays.asList(
                new Course<>("AI", new ResearchCourse("Thesis")),
                new Course<>("ML", new ResearchCourse("Research Paper"))
        );

        CourseUtil.displayCourseList(examCourses);
        CourseUtil.displayCourseList(assignmentCourses);
        CourseUtil.displayCourseList(researchCourses);

        List<ExamCourse> examTypes = Arrays.asList(
                new ExamCourse("Semester Exam"),
                new ExamCourse("Unit Test")
        );

        CourseUtil.displayCourses(examTypes);
    }
}