import java.util.*;

class Patient {
    int id;

    public Patient(int id) {
        this.id = id;
    }

    public void printId() {
        System.out.println(id);
    }
}

public class PatientIDPrinting {
    public static void main(String[] args) {

        List<Patient> patients = Arrays.asList(
                new Patient(101),
                new Patient(102),
                new Patient(103),
                new Patient(104)
        );

        patients.forEach(Patient::printId);
    }
}