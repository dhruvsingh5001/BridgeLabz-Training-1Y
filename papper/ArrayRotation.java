import java.util.*;

public class ArrayRotation {

    static void leftRotate(int arr[], int d) {
        int n = arr.length;
        d = d % n;
        int temp[] = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }
        for (int i = 0; i < d; i++) {
            arr[n - d + i] = temp[i];
        }
        System.out.println("Left Rotation: " + Arrays.toString(arr));
    }
    static void rightRotate(int arr[], int d) {
        int n = arr.length;
        d = d % n;
        int temp[] = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[n - d + i];
        }
        for (int i = n - d - 1; i >= 0; i--) {
            arr[i + d] = arr[i];
        }
        for (int i = 0; i < d; i++) {
            arr[i] = temp[i];
        }
        System.out.println("Right Rotation: " + Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {1, 2, 3, 4, 5};
        int d = 2;
        leftRotate(arr1, d);
        rightRotate(arr2, d);
    }
}