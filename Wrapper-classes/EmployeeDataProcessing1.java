import java.util.*;

public class EmployeeDataProcessing1 {
    public static void main(String[] args) {
        int[] ages = {25, 32, 19, 45, 28, 21};

        ArrayList<Integer> list = new ArrayList<>();

        for (int age : ages) {
            list.add(Integer.valueOf(age));
        }

        int youngest = Collections.min(list);
        int oldest = Collections.max(list);

        System.out.println("Ages: " + list);
        System.out.println("Youngest: " + youngest);
        System.out.println("Oldest: " + oldest);
    }
}