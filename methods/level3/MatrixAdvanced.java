import java.util.*;

public class MatrixAdvanced {

    static double[][] createRandomMatrix(int r,int c){
        double[][] m=new double[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                m[i][j]=(int)(Math.random()*9)+1;
        return m;
    }

    static double[][] transpose(double[][] m){
        int r=m.length,c=m[0].length;
        double[][] t=new double[c][r];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                t[j][i]=m[i][j];
        return t;
    }

    static double determinant(double[][] m){
        int n=m.length;
        if(n==1) return m[0][0];
        if(n==2) return m[0][0]*m[1][1]-m[0][1]*m[1][0];
        double det=0;
        for(int k=0;k<n;k++){
            double[][] sub=new double[n-1][n-1];
            for(int i=1;i<n;i++){
                int col=0;
                for(int j=0;j<n;j++){
                    if(j==k) continue;
                    sub[i-1][col++]=m[i][j];
                }
            }
            det+=Math.pow(-1,k)*m[0][k]*determinant(sub);
        }
        return det;
    }

    static double[][] inverse(double[][] m){
        int n=m.length;
        double det=determinant(m);
        if(det==0) return null;

        double[][] adj=new double[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                double[][] sub=new double[n-1][n-1];
                int r=0;
                for(int x=0;x<n;x++){
                    if(x==i) continue;
                    int c=0;
                    for(int y=0;y<n;y++){
                        if(y==j) continue;
                        sub[r][c++]=m[x][y];
                    }
                    r++;
                }
                adj[j][i]=Math.pow(-1,i+j)*determinant(sub);
            }
        }

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                adj[i][j]/=det;

        return adj;
    }

    static void print(double[][] m){
        if(m==null){ System.out.println("Inverse doesn't exist"); return; }
        for(double[] r:m){
            for(double v:r) System.out.printf("%.2f ",v);
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size of square matrix: ");
        int n=sc.nextInt();

        double[][] matrix=createRandomMatrix(n,n);

        System.out.println("Matrix:");
        print(matrix);

        System.out.println("Transpose:");
        print(transpose(matrix));

        System.out.println("Determinant:");
        System.out.println(determinant(matrix));

        System.out.println("Inverse:");
        print(inverse(matrix));
    }
}
