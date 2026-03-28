import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[][] marks = new double[n][3]; // 0=Physics,1=Chemistry,2=Maths
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Physics marks: ");
            double p = sc.nextDouble();

            System.out.print("Chemistry marks: ");
            double c = sc.nextDouble();

            System.out.print("Maths marks: ");
            double m = sc.nextDouble();

            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Invalid marks! Enter again.");
                i--; // retry same student
                continue;
            }

            marks[i][0] = p;
            marks[i][1] = c;
            marks[i][2] = m;
        }

        for (int i = 0; i < n; i++) {

            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3;

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
