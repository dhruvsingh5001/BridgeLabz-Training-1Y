//  Simple program for taking User input:

import java.util.Scanner;  // import packages

class UserInput{   // class name
public static void main(String args[]){ //main method JVM internally calls
   
    Scanner sc=new Scanner(System.in); //Sacnner class User input
    System.out.println("Enter a number"); // Priniting statment.
    int num = sc.nextInt();   // Taking  input
   
    System.out.println("Number: "+num); // printing statement

}
}