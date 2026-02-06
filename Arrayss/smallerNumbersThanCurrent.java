package Arrayss;
import java.util.*;
public  class smallerNumbersThanCurrent {
	
//learned: about frequency array and .clone() and putIfAbsent() 	
	/**
	 * LeetCode 1365: How Many Numbers Are Smaller Than the Current Number
	 *
	 * Approaches:
	 * 1️ Brute Force (O(n*n)) - Compare each pair of numbers.
	 * 2️ Counting/Frequency Array (O(n + k)) - Use prefix sum since 0 <= nums[i] <= 100.
	 * 3️ Sorting + HashMap (O(n log n)) - Sort a copy of the array and record first indices.
	 */

	    
	    public int[] check(int[] nums) {
	        int n = nums.length;

	        //  Do NOT do: int[] sorted = nums;
	        // Because that would make 'sorted' reference the same array as 'nums',
	        // and sorting it would also change 'nums' itself.
	        // Instead, we clone it to keep the original order intact.
	        int[] sorted = nums.clone();
	        Arrays.sort(sorted);

	        // Map each number to how many numbers are smaller than it
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < n; i++) {
	            // Only record the first occurrence, since earlier index = smaller count
	            map.putIfAbsent(sorted[i], i);
	        }

	        // Build result array using the map
	        int[] result = new int[n];
	        for (int i = 0; i < n; i++) {
	            result[i] = map.get(nums[i]);
	        }

	        return result;
	    }

	    public static void main(String[] args) {
	        smallerNumbersThanCurrent sol = new smallerNumbersThanCurrent();

	        int[] nums = {8, 1, 2, 2, 3};
	        int[] result = sol.check(nums);

	        System.out.println("Input:  " + Arrays.toString(nums));
	        System.out.println("Output: " + Arrays.toString(result));
	    
	}
}
// ---------- Approach 1: Brute Force (O(n²)) ----------
/*
public int[] check(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] < nums[i]) {
                count++;
            }
        }
        result[i] = count;
    }

    return result;
}
 */

    // ----------&&&&&&&&&&&&&&&&&&& Approach 2: Counting / Frequency Array (O(n + k))&&&&&&&&&&&&&&&&& ----------
    /* counting sort algo/ one of many imp pattern to watch out for, when you need to count number of smaller elements or count in general, then think of counting  sort algo 
    public int[] check(int[] nums) {
        int[] freq = new int[101];  // since 0 <= nums[i] <= 100

        // Count frequencies
        for (int num : nums) {
            freq[num]++;
        }

        // Compute prefix sums
        for (int i = 1; i < 101; i++) {
            freq[i] += freq[i - 1];
        }

        // Build result
        int[] result = new int[nums.length];
       for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
            result[i] = 0; // no number is smaller than 0
        } else {
            result[i] = freq[nums[i] - 1]; // numbers smaller than nums[i]
        }
    }

        return result;
    }
Fast → O(n + 100) ≈ O(n)
No sorting needed
Very common interview pattern
Uses counting + prefix sum
    
}*/



