package Arrayss;

import java.util.Arrays;

public class reverse_array {
public static void main(String[] args) {
	int [] a= {5,6,68,55,2,96,66};
	reverse(a);
	System.out.println(Arrays.toString(a));
	/*String name="vedant";
	System.out.println(Arrays.toString(name.toCharArray()));
*/
	}
	static void reverse(int[] a)
	{
		int i=0; int j=a.length-1;
		while(i<j)
		{
			swap(a,i,j);
			i++;
			j--;
			/*   // Inline swap logic, no need of swap()
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;*/
		}
	}
	static void swap (int []a,int i1,int i2)
	{ int temp=a[i1];
	a[i1]=a[i2];
	a[i2]=temp;
	
		
	}
}

/*

 */
