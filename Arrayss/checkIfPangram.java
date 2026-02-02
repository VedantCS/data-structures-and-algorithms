package Arrayss;

//import java.util.HashMap;
//A PanGram is a sentence where every letter of the English alphabet appears at least once.
public class checkIfPangram {
	public static boolean check(String sentence) {
	    /*worst approach not memory efficient 
	     HashMap<Integer, Boolean> mpp=new HashMap<>(26);
	    for(int i=97;i<=122;i++)
	    {
	        mpp.put(i,false);
	    }
	    for(int i=0;i<sentence.length();i++)
	    {
	        mpp.put((int)sentence.charAt(i),true);
	    }
	      for (boolean value : mpp.values())
	       {
	    if (!value) return false;
	}return true; 
	}*/ 
		//--Better approach using boolean array ->gives Constant space complexity (O(1)). and T.C of 0(N)
		 sentence = sentence.toLowerCase();  // normalize case
		boolean[] seen = new boolean[26];
	    
	    for (char c : sentence.toCharArray()) {
	       
	    	 if (c >= 'a' && c <= 'z') {  //  only count lowercase letters
	    		 seen[c - 'a'] = true;
	    	 }
	    }	
	    
	    for (boolean present : seen) {
	        if (!present) return false;
	    }
	    return true;
	}
//easier approach
	 // Set<Character> set =new HashSet<>();//set does not allow duplicates
    // for(int i=0; i < sentence.length(); i++){
    //     set.add(sentence.charAt(i));
    // }
    // return set.size() == 26 ? true : false;
		
	//the most efficient way is to use Bit Masking which i don't know yet
	public static void main(String[] args) {
		String a="thequickbrownfoxjumpsoverthelazydog";
		String b="Guten Tag";
		System.out.println(check(a));
		System.out.println(check(b));
	}
}
