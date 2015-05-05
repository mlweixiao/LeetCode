package P132_Palindrome_Partitioning_II;

public class Solution {
	public int minCut(String s) {
		int[] ans = new int[s.length()];
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) 
            isPalindrome[i][i] = true;
        
        for (int i = 0; i < s.length() - 1; i++) 
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                    = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }
        
		for (int i = 1; i < s.length(); i++) {
			if (isPalindrome[0][i])
				continue;
			ans[i] = Integer.MAX_VALUE;
			for (int j = 1; j <= i; j++) {
				if (isPalindrome[j][i] && ans[i] - 1 > ans[j - 1]) {
					ans[i] = 1 + ans[j - 1];
				}
			}
		}
		return ans[s.length() - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String str = new String("aab");
		System.out.println(s.minCut(str));
	}

}
