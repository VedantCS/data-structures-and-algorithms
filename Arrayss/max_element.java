package Arrayss;

public class max_element {
public static void main(String[] args) {
	int [] a= {1,4,412,14,5546,751,411,654};
	System.out.println(max(a));
}
static int max(int []a)
{
	  int max =Integer.MIN_VALUE;  // Start with the first element
      for (int i = 0; i < a.length; i++) {
          if (a[i] > max) {
              max = a[i];  // Update if current element is greater
          }
      }
      return max;}
}
