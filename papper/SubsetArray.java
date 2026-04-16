import java.util.HashSet;

public class SubsetArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5};
        if (isSubset(arr1, arr2)) {
            System.out.println("arr2 is a subset of arr1");
        } else {
            System.out.println("arr2 is NOT a subset of arr1");
        }
    }
    public static boolean isSubset(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            if (!set.contains(num)) {
                return false;
            }
        }
        return true;
    }
}