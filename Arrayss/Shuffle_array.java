package Arrayss;

import java.util.Arrays;

/*
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].
Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7] 

Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]

*/
public class Shuffle_array {
	 public static int[] shuffle(int[] nums, int n)
	 {	int arr[]=new int[2*n];
		for(int i=0;i<n;i++)
		{ arr[2*i]=nums[i];//we can see that x values are at even position
		  arr[2*i+1]=nums[i+n];//y values are at odd position
			
		}
		 return arr;
	 }

	public static void main(String[] args) {
   int[] a= {1,2,3,4,4,3,2,1}; int n=4;
   int[] res=shuffle(a,n);
   System.out.println(Arrays.toString(res));
	
	}
}
