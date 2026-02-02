package Arrayss;

import java.util.Arrays;

public class swap_values {
public static void main(String[] args) {
	int [] a= {1,4,412,14,12,411};
	
	swap(a,2,5);
	System.out.println(Arrays.toString(a));//returns a string representation of the contents of the specified array. 
	//The string representation consists of a list of the array's elements, enclosed in square brackets ("[]").
}
static void swap(int []a, int index1,int index2)
{	int temp=0;
	temp=a[index1];
	a[index1]=a[index2];
	a[index2]=temp;
	
}
}
