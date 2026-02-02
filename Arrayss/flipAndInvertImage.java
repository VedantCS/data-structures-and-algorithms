package Arrayss;
//Learned- Bitwise XOR and how it [XOR 1] helps Inverting 0 and 1 with XOR
/*
|   x   | x ^ 1 |
|----- 	| ----- |
| 0		| 1     |
| 1 	| 0     |
*/
public class flipAndInvertImage {
	//rotate horizontally then invert 0 to 1 and 1 to 0
	
	    public int[][] flipAndInvertImage(int[][] image) {
	        flip(image);
	        for (int i = 0; i < image.length; i++) {
	            for (int j = 0; j < image[i].length; j++) {
	                image[i][j] = image[i][j] == 0 ? 1 : 0;
	            }
	        }
	        return image;
	    }

	    void flip(int[][] image) {
	        for (int i = 0; i < image.length; i++) {
	            int left = 0, right = image[i].length - 1;
	            while (left < right) {
	                int temp = image[i][left];
	                image[i][left] = image[i][right];
	                image[i][right] = temp;
	                left++;
	                right--;
	            }
	        }
	    }
//simpler solution: Bitwise XOR
/*public int[][] flipAndInvertImage(int[][] image) {
       **** for (int[] row : image) {
            int left = 0, right = row.length - 1;
            while (left <= right) {
                // Swap and invert in one step using XOR
                
                int temp = row[left] ^ 1;//inverts left
                row[left] = row[right] ^ 1;//inverts right
                row[right] = temp;
                left++;
                right--;
            }
        }
        return image;
    }*/	    
	    // main method
	    public static void main(String[] args) {
	       flipAndInvertImage solution = new flipAndInvertImage();

	        int[][] image = {
	            {1, 1, 0},
	            {1, 0, 1},
	            {0, 0, 0}
	        };

	        int[][] result = solution.flipAndInvertImage(image);

	        System.out.println("Flipped and Inverted Image:");
	        for (int[] row : result) {
	            for (int val : row) {
	                System.out.print(val + " ");
	            }
	            System.out.println();
	        }
	    }
	}


