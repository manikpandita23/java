import java.util.Arrays;
public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;
        int iterativeResult = binarySearchIterative(sortedArray, target);
        System.out.println("Iterative Binary Search Result: " + (iterativeResult >= 0 ? "Element found at index " + iterativeResult : "Element not found"));
        int recursiveResult = binarySearchRecursive(sortedArray, target, 0, sortedArray.length - 1);
        System.out.println("Recursive Binary Search Result: " + (recursiveResult >= 0 ? "Element found at index " + recursiveResult : "Element not found"));
    }
    public static int binarySearchIterative(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (array[mid] < target) {
            return binarySearchRecursive(array, target, mid + 1, right);
        } else {
            return binarySearchRecursive(array, target, left, mid - 1);
        }
    }
}