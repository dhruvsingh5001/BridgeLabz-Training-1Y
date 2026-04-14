import java.util.*;

abstract class JobRole {
    String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String toString() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    String candidateName;
    T role;

    public Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public String toString() {
        return candidateName + " - " + role;
    }
}

class ScreeningUtil {
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Processing: " + resume);
    }

    public static void processAll(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Screening for role: " + role);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> r2 = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> r3 = new Resume<>("Charlie", new ProductManager());

        ScreeningUtil.processResume(r1);
        ScreeningUtil.processResume(r2);
        ScreeningUtil.processResume(r3);

        List<JobRole> roles = Arrays.asList(
                new SoftwareEngineer(),
                new DataScientist(),
                new ProductManager()
        );

        ScreeningUtil.processAll(roles);
    }
}