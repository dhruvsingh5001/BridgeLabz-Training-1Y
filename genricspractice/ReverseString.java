import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Dhruv";
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        
        String reversed = "";
        while(!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }
        
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversed);
    }
}