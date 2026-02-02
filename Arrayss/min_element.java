package Arrayss;

public class min_element {
public static void main(String[] args) {
		int []a= {55,-55,1,-1,-666,-66};
		System.out.println(min(a));
}
static int min(int []a)
{
	int min=Integer.MAX_VALUE;
	for(int i:a)
		
	{
		if(i<min) min=i;
	}
	return min;
}

	}

