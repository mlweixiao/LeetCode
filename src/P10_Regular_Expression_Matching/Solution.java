package P10_Regular_Expression_Matching;

public class Solution {
    public static boolean isMatch(String s, String p) {
    	boolean result=s.matches(p);
    	System.out.println(result);
    	return result;
    	
//    	for(int i=0;i<p.length();i++){
//    		if()
//    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isMatch("aa","a");
		isMatch("aa","aa");
		isMatch("aaa","aa");
		isMatch("aa", "a*");
		isMatch("aa", ".*");
		isMatch("ab", ".*");
		isMatch("aab", "aaac*a*b");
	}

}
