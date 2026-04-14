import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public int compareTo(Patient p) {
        return p.severity - this.severity;
    }

    public String toString() {
        return name + " (" + severity + ")";
    }
}

class HospitalTriage {
    public static void processPatients(List<Patient> patients) {
        PriorityQueue<Patient> pq = new PriorityQueue<>(patients);

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
                new Patient("John", 3),
                new Patient("Alice", 5),
                new Patient("Bob", 2)
        );

        HospitalTriage.processPatients(patients);
    }
}