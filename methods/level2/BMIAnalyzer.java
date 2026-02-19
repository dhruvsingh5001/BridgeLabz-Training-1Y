import java.util.Scanner;

public class BMIAnalyzer {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInMeters = data[i][1] / 100.0; 
            data[i][2] = weight / (heightInMeters * heightInMeters);
        }
    }

    public static String[] determineStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) status[i] = "Underweight";
            else if (bmi < 24.9) status[i] = "Normal weight";
            else if (bmi < 29.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] teamData = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            teamData[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            teamData[i][1] = sc.nextDouble();
        }

        calculateBMI(teamData);
        String[] statuses = determineStatus(teamData);

        System.out.println("\nWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s\n", 
                teamData[i][0], teamData[i][1], teamData[i][2], statuses[i]);
        }

        sc.close();
    }
}
