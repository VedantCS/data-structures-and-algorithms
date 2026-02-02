package Arrayss;
import java.util.HashMap;
//A pair (i, j) is called good if nums[i] == nums[j] and i < j.
public class IdenticalPairs {
public static void main(String[] args) {
	int []arr= {1,2,3,1,1,3}; //o/p should be 4 as There are 4 good pairs on index (0,3), (0,4), (3,4), (2,5) where i<j and nums[i] == nums[j]
	System.out.println("Identical pairs: "+numIdenticalPairs(arr) );
}
static int numIdenticalPairs(int[] nums)
{
	
	 /*O(N^2) Approach for (int i = 0; i < nums.length; i++) { int count=0;
          for (int j = i + 1; j < nums.length; j++) {
              if (nums[i] == nums[j]) {
                  count++;
              }
          }
      }*/
	//	OPTIMIZED(O(N) Solution
	  HashMap<Integer, Integer> freq = new HashMap<>();
      int count = 0;
      for (int num : nums) {
     //********************************a very common pattern in Java when counting how many times something appears****************
    	  count += freq.getOrDefault(num, 0);
          freq.put(num, freq.getOrDefault(num, 0) + 1);
      }
      
 /*******************A HashMap does not allow duplicate keys —***************************
*********************but you can update the value for an existing key.*******************

*************************So you don’t insert a duplicate key*****************************
*************************you just replace (update) the value stored for that key.********

mpp.getOrDefault(num, 0) → looks up the current count of num in the map.
		If num is not in the map yet, it returns 0.
		If num is already there, it returns the current count.
		+1 → adds 1 to that count because we’ve just seen one more occurrence of num.
		mpp.put(num, ...) → updates the map with the new count.
*/

	
return count;}
	
}
/* leetcode: contains duplicate:
 * class Solution {
    public boolean containsDuplicate(int[] nums) {
        int count=0;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int num:nums){//remember this pattern;
            count+=mpp.getOrDefault(num,0);
            mpp.put(num,mpp.getOrDefault(num,0)+1);
        }
        if(count>0)return true;
        else return false;
    }
}*/
