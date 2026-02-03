import java.util.Scanner;
class Continue{
public static void main(String[] args){

Scanner sc=new Scanner(System.in);

System.out.println("Enter the Last number");
int n=sc.nextInt();

System.out.println("Even numbers in series are");

for(int i=1;i<=n;i++){
if(i%2==1){
continue;
}
System.out.println(i);
}
}
}
