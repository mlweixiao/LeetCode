package P140_Word_Break_II;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public List<String> wordBreak(String s, Set<String> dict) {
		int length = s.length();
		boolean[] flag = new boolean[length + 1];
		boolean[][] tmp=new boolean[length+1][length+1];
		flag[0] = true;
		for (int i = 0; i < length; i++) {
			if (flag[i]) {
				for (int len = 1; i + len - 1 < length; len++) {
					if (dict.contains(s.substring(i, i + len))){
						flag[i + len] = true;
						tmp[i][i+len]=true;
					}
				}
			}
		}
		return flag[length];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String str = new String("abcd");
		Set<String> dict = new HashSet<String>();
		String [] string =new String []{"a","abc","b","cd"}; 
		dict.addAll( Arrays.asList(string));
		System.out.println(s.wordBreak(str, dict,1));
	}

}
