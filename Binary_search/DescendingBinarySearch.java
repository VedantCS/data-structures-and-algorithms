package Binary_search;

public class DescendingBinarySearch {
    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int target = 5;
        int result = bsDescending(a, target);
        System.out.println("Element found at index: " + result);
    }

    static int bsDescending(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                // In descending, target must be to the left
                end = mid - 1;
            } else {
                // target must be to the right
                start = mid + 1;
            }
        }

        return -1;
    }
}
