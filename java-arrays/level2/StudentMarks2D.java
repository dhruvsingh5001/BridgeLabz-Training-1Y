import java.util.Scanner;

public class StudentMarks2D {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[][] marks = new double[n][3]; // [student][subject]
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            for (int j = 0; j < 3; j++) {

                String subject = "";
                if (j == 0) subject = "Physics";
                else if (j == 1) subject = "Chemistry";
                else subject = "Maths";

                System.out.print(subject + " marks: ");
                double value = sc.nextDouble();

                if (value < 0) {
                    System.out.println("Invalid marks! Enter again.");
                    j--; 
                    continue;
                }

                marks[i][j] = value;
            }
        }

        for (int i = 0; i < n; i++) {

            double sum = 0;

            for (int j = 0; j < 3; j++) {
                sum += marks[i][j];
            }

            percentage[i] = sum / 3;

            if (percentage[i] >= 90)
                grade[i] = 'A';
            else if (percentage[i] >= 75)
                grade[i] = 'B';
            else if (percentage[i] >= 60)
                grade[i] = 'C';
            else if (percentage[i] >= 40)
                grade[i] = 'D';
            else
                grade[i] = 'F';
        }

        System.out.println("\n--- Student Report ---");

        for (int i = 0; i < n; i++) {

            System.out.println("Student " + (i + 1)
                    + " | Physics = " + marks[i][0]
                    + " | Chemistry = " + marks[i][1]
                    + " | Maths = " + marks[i][2]
                    + " | Percentage = " + String.format("%.2f", percentage[i])
                    + "% | Grade = " + grade[i]);
        }

        sc.close();
    }
}
