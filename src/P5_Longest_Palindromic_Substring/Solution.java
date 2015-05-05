package P5_Longest_Palindromic_Substring;

public class Solution {
	
	public String longestPalindrome_1(String s)
	{
		int n=s.length();
	    int i=0, j=0, max=1,c=1;
	    String result=s;
	    for (i = 0; i < n; i++) { // i is the middle point of the palindrome  
	        for (j = 0; (i - j >= 0) && (i + j < n); j++){ // if the length of the palindrome is odd  
	            if (s.charAt(i-j) !=s.charAt(i+j))
	                break;
	            c = j * 2 + 1;
	        }
	        if (c > max){
	            max = c;
	            result=s.substring(i-j+1,i+j);
	        }
	        for (j = 0; (i - j >= 0) && (i + j + 1 < n); j++){ // for the even case  
	            if (s.charAt(i-j) != s.charAt(i+j+1))
	                break;
	            c = j * 2 + 2;
	        }
	        if (c > max){
	            max = c;
	            result=s.substring(i-j+1,i+j+1);
	        }
	    }
	    return result;
	}
	
	// Transform S into T.
	// For example, S = "abba", T = "$#a#b#b#a#^".
	// ^ and $ signs are sentinels appended to
	// each end to avoid bounds checking
	private String preProcess(String s) {
		if (s.length() == 0)
			return "$#";
		StringBuffer sb = new StringBuffer("$#");
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			sb.append('#');
		}
		sb.append("^");
		return sb.toString();
	}

	public String longestPalindrome(String s) {
		String t = preProcess(s);
		int n = t.length();
		int[] p = new int[n];
		int id = 0, mx = 0;
		for (int i = 1; i < n-1; i++) {
			int j = 2 * id - i; // equals to i' = id - (i-id)
			p[i] = mx > i ? Math.min(mx - i, p[j]) : 0;

			// Attempt to expand palindrome centered at i
			while (t.charAt(i + p[i]) == t.charAt(i - p[i])) {
				p[i]++;
			}
			// If palindrome centered at i expand past R,
			// adjust center based on expanded palindrome.
			if (i + p[i] > mx) {
				id = i;
				mx = i + p[i];
			}
		}

		// Find the maximum element in P.
		int maxLen = 0;
		int centerIndex = 0;
		for (int i = 0; i < n; i++) {
			if (p[i] > maxLen) {
				maxLen = p[i];
				centerIndex = i;	
			}
		}
		
		return s.substring((centerIndex - maxLen) / 2,
				(centerIndex - maxLen) / 2+maxLen-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String str = new String("b");
		System.out.println(s.longestPalindrome_1(str));
	}

}
