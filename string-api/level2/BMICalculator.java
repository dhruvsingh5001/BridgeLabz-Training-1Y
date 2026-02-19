import java.util.Scanner;

public class BMICalculator {

    public static String[] calculateBMIStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        bmi = Math.round(bmi * 100.0) / 100.0;
        String status;
        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 25) status = "Normal";
        else if (bmi < 30) status = "Overweight";
        else status = "Obese";
        return new String[]{String.valueOf(weight), String.valueOf(heightCm), String.valueOf(bmi), status};
    }

    public static String[][] computeBMIForTeam(double[][] hw) {
        int n = hw.length;
        String[][] result = new String[n][4];
        for (int i = 0; i < n; i++) {
            result[i] = calculateBMIStatus(hw[i][0], hw[i][1]);
        }
        return result;
    }

    public static void displayBMIResults(String[][] bmiData) {
        System.out.println("Weight(kg)\tHeight(cm)\tBMI\tStatus");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < bmiData.length; i++) {
            System.out.println(bmiData[i][0] + "\t\t" + bmiData[i][1] + "\t\t" + bmiData[i][2] + "\t" + bmiData[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        double[][] hw = new double[n][2];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i+1) + ": ");
            hw[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i+1) + ": ");
            hw[i][1] = sc.nextDouble();
        }
