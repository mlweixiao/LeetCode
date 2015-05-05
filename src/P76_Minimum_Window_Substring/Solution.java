package P76_Minimum_Window_Substring;

import java.util.HashMap;

public class Solution {
	public String minWindow(String S, String T) {
		if (S == null || S.length() == 0) {
			return S;
		}
		if (T == null || T.length() == 0) {
			return "";
		}

		HashMap<Character, Integer> tCounter = new HashMap<Character, Integer>();
		Character c;
		for (int i = 0; i < T.length(); i++) {
			c = T.charAt(i);
			if (tCounter.containsKey(c)) {
				tCounter.put(c, tCounter.get(c) + 1);
			} else {
				tCounter.put(c, 1);
			}
		}
		HashMap<Character, Integer> minWindowCounter = new HashMap<Character, Integer>();
		String minWindow = null;
		int tCount = T.length();
		int begin = 0, end = 0,temp=0;
		for (end = 0; end < S.length(); end++) {
			c = S.charAt(end);
			if (!tCounter.containsKey(c)) {
				continue;
			}
			if(minWindowCounter.containsKey(c)){
				minWindowCounter.put(c, minWindowCounter.get(c) +1);
			}else {
				minWindowCounter.put(c,  1);
			}
			if (minWindowCounter.get(c) <=tCounter.get(c)) {
				tCount--;
			}
			
			if (tCount == 0) {
				for (begin = temp; begin <= end; begin++) {
					c = S.charAt(begin);
					if (!tCounter.containsKey(c)) {
						continue;
					}
					if (minWindowCounter.get(c) <=tCounter.get(c)) {//头指针不能再收缩了
						temp=begin;
						if(minWindow==null||end+1-begin<minWindow.length()){
							minWindow = S.substring(begin, end + 1);
						}
						break;
					}else{
						minWindowCounter.put(c, minWindowCounter.get(c)-1);
					}
				}
			}	
		}
		return minWindow!=null?minWindow:"";
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String S = new String("ADOBECODEBANC");
		String T = new String("ABC");
		System.out.println(s.minWindow(S, T));
	}
}