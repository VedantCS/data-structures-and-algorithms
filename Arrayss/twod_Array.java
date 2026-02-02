package Arrayss;

import java.util.Scanner;

public class twod_Array {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int [][] arr= new int [3][2];
	System.out.println(arr.length);//this will give number of rows
	for(int i=0;i<arr.length;i++)
	{
		for(int j=0;j<arr[i].length;j++)
		{
			arr[i][j]=sc.nextInt();
		}
	}

	for(int i=0;i<arr.length;i++)
	{
		for(int j=0;j<arr[i].length;j++)
		{
			System.out.print(arr[i][j]+ " ");
		} System.out.println();
	}

sc.close();}

}
