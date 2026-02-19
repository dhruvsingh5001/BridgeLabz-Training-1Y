import java.util.*;

public class MatrixOperations {

    static int[][] createRandomMatrix(int r,int c){
        int[][] m=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                m[i][j]=(int)(Math.random()*10);
        return m;
    }

    static int[][] add(int[][] a,int[][] b){
        int r=a.length,c=a[0].length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                res[i][j]=a[i][j]+b[i][j];
        return res;
    }

    static int[][] subtract(int[][] a,int[][] b){
        int r=a.length,c=a[0].length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                res[i][j]=a[i][j]-b[i][j];
        return res;
    }

    static int[][] multiply(int[][] a,int[][] b){
        int r=a.length,c=b[0].length,n=b.length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                for(int k=0;k<n;k++)
                    res[i][j]+=a[i][k]*b[k][j];
        return res;
    }

    static void printMatrix(int[][] m){
        for(int[] row:m){
            for(int v:row) System.out.print(v+" ");
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Rows: ");
        int r=sc.nextInt();
        System.out.print("Cols: ");
        int c=sc.nextInt();

        int[][] A=createRandomMatrix(r,c);
        int[][] B=createRandomMatrix(r,c);

        System.out.println("Matrix A:");
        printMatrix(A);

        System.out.println("Matrix B:");
        printMatrix(B);

        System.out.println("Addition:");
        printMatrix(add(A,B));

        System.out.println("Subtraction:");
        printMatrix(subtract(A,B));

        System.out.print("Enter columns of B for multiplication: ");
        int c2=sc.nextInt();

        int[][] B2=createRandomMatrix(c,c2);

        System.out.println("Matrix B for multiplication:");
        printMatrix(B2);

        System.out.println("Multiplication:");
        printMatrix(multiply(A,B2));
    }
}
