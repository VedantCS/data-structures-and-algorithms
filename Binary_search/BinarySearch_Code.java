package Binary_search;

public class BinarySearch_Code {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(bs(a, 55));  // Output should be 4 (index of value 5)
    }

    static int bs(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;

        while (start <= end) { 
//basic way to find mid= (start+end)/2 , but it can cause integer overflow when start + end exceeds the maximum value an int can hold.
// INT Maximum value: 2,147,483,647 (which is (2^{31}-1)) Minimum value: -2,147,483,648 (which is (-2^{31}))
/*eg: int start = 2_000_000_000;
        	int end = 2_000_000_000;
        	int mid = (start + end) / 2;
THEN start + end = 4_000_000_000 // This is beyond Integer.MAX_VALUE This will wrap around into a negative number due to overflow, and mid will be incorrect.
Hence to avoid adding two large numbers:
int mid = start + (end - start) / 2;
end - start = 10
(start + 10 / 2) = 2_000_000_005 this remains in int range

TLDR:
********************Use start + (end - start) / 2 in binary search to avoid integer overflow when working with large arrays or values.*******************/


            int mid = start + (end - start) / 2; // Prevents overflow

            if (a[mid] == target) {
                return mid; // Target found
            } else if (a[mid] < target) {
                start = mid + 1; // Search in right half
            } else {
                end = mid - 1; // Search in left half
            }
        }

        return -1; // Target not found
    }
}
