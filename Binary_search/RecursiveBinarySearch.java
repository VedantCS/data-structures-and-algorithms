package Binary_search;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;

        int result = binarySearch(a, target, 0, a.length - 1);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }

    static int binarySearch(int[] a, int target, int start, int end) {
        // Base case: element not found
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (a[mid] == target) {
            return mid;
        } else if (a[mid] < target) {
            return binarySearch(a, target, mid + 1, end); // Search right half
        } else {
            return binarySearch(a, target, start, mid - 1); // Search left half
        }
    }
}
