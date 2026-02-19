import java.util.*;

public class StudentMarks {

    static int[][] generateScores(int n){
        int[][] marks=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                marks[i][j]=(int)(Math.random()*90)+10;
            }
        }
        return marks;
    }

    static double[][] calculateResults(int[][] marks){
        int n=marks.length;
        double[][] res=new double[n][3];
        for(int i=0;i<n;i++){
            int total=marks[i][0]+marks[i][1]+marks[i][2];
            double avg=total/3.0;
            double per=(total/300.0)*100;
            res[i][0]=Math.round(total*100.0)/100.0;
            res[i][1]=Math.round(avg*100.0)/100.0;
            res[i][2]=Math.round(per*100.0)/100.0;
        }
        return res;
    }

    static void display(int[][] marks,double[][] res){
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\tPer%");
        for(int i=0;i<marks.length;i++){
            System.out.println(
                marks[i][0]+"\t"+
                marks[i][1]+"\t"+
                marks[i][2]+"\t"+
                res[i][0]+"\t"+
                res[i][1]+"\t"+
                res[i][2]
            );
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n=sc.nextInt();
        int[][] marks=generateScores(n);
        double[][] results=calculateResults(marks);
        display(marks,results);
    }
}
