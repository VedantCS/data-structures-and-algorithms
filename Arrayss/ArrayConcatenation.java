package Arrayss;

import java.util.Arrays;

public class ArrayConcatenation {
public static void main(String[] args) {
	int [] arr= {11,22,33};
	
	System.out.println(Arrays.toString(getConcatenation(arr)));

}
static public int[] getConcatenation(int[] nums) {
    int n = nums.length;
    int[] ans = new int[2 * n];
    for (int i = 0; i < n; i++) {
        ans[i] = nums[i];
        ans[i + n] = nums[i];
    }
    
    return ans;
	

	}
}