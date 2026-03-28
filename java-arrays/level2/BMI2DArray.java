import java.util.Scanner;

public class BMI2DArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {

            System.out.println("\nPerson " + (i + 1));

            while (true) {
                System.out.print("Enter weight (kg): ");
                double weight = sc.nextDouble();

                if (weight > 0) {
                    personData[i][0] = weight;
                    break;
                } else {
                    System.out.println("Invalid! Enter positive weight.");
                }
            }

            while (true) {
                System.out.print("Enter height (meters): ");
                double height = sc.nextDouble();

                if (height > 0) {
                    personData[i][1] = height;
                    break;
                } else {
                    System.out.println("Invalid! Enter positive height.");
                }
            }
        }

        for (int i = 0; i < number; i++) {

            double weight = personData[i][0];
            double height = personData[i][1];

            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            if (bmi < 18.5)
                weightStatus[i] = "Underweight";
            else if (bmi < 24.9)
                weightStatus[i] = "Normal weight";
            else if (bmi < 29.9)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }

        System.out.println("\n--- BMI REPORT ---");
        for (int i = 0; i < number; i++) {

            System.out.println("Person " + (i + 1)
                    + " | Weight = " + personData[i][0] + " kg"
                    + " | Height = " + personData[i][1] + " m"
                    + " | BMI = " + String.format("%.2f", personData[i][2])
                    + " | Status = " + weightStatus[i]);
        }

        sc.close();
    }
}
