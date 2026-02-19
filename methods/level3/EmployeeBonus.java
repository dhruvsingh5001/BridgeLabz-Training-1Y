import java.util.*;

public class EmployeeBonus {

    static double[][] generateData(int n){
        double[][] arr = new double[n][2];
        for(int i=0;i<n;i++){
            int salary = (int)(Math.random()*90000)+10000;
            int years = (int)(Math.random()*10)+1;
            arr[i][0] = salary;
            arr[i][1] = years;
        }
        return arr;
    }

    static double[][] calculateBonus(double[][] data){
        double[][] result = new double[data.length][2];
        for(int i=0;i<data.length;i++){
            double salary = data[i][0];
            double years = data[i][1];
            double bonus = (years>5)? salary*0.05 : salary*0.02;
            result[i][0] = salary + bonus;
            result[i][1] = bonus;
        }
        return result;
    }

    static void display(double[][] oldData,double[][] newData){
        double sumOld=0,sumNew=0,sumBonus=0;
        System.out.println("Emp\tOldSalary\tYears\tBonus\tNewSalary");
        for(int i=0;i<oldData.length;i++){
            System.out.println((i+1)+"\t"+(int)oldData[i][0]+"\t\t"+(int)oldData[i][1]+"\t"+(int)newData[i][1]+"\t"+(int)newData[i][0]);
            sumOld+=oldData[i][0];
            sumNew+=newData[i][0];
            sumBonus+=newData[i][1];
        }
        System.out.println("---------------------------------------------");
        System.out.println("Total\t"+(int)sumOld+"\t\t\t"+(int)sumBonus+"\t"+(int)sumNew);
    }

    public static void main(String[] args){
        int n=10;
        double[][] employees = generateData(n);
        double[][] updated = calculateBonus(employees);
        display(employees,updated);
    }
}
