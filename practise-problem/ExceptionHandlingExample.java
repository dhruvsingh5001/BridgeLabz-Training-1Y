public class ExceptionHandlingExample{
public static void main(String args[] ) {
int A=20;
int B=0;
try{
int C=A/B;
System.out.println("the result is"+C);
}
catch(ArithmeticException e) {
    System.out.println("Error: Cannot divide by zero");
}
finally{
System.out.println("Finally block");
}
}
}