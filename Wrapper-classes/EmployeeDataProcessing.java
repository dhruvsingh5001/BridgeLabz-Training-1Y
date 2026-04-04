import java.util.*;

public class EmployeeDataProcessing {
    public static void main(String[] args) {
        int[] agesArray = {25, 32, 19, 45, 28, 21};

        ArrayList<Integer> ageList = new ArrayList<>();

        for (int age : agesArray) {
            ageList.add(Integer.valueOf(age));
        }

        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

        System.out.println("Ages List: " + ageList);
        System.out.println("Youngest Age: " + youngest);
        System.out.println("Oldest Age: " + oldest);
    }
}