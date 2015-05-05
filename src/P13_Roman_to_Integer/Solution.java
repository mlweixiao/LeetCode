package P13_Roman_to_Integer;

import java.util.HashMap;

public class Solution {
	public int romanToInt(String s) {
		if (s.length() == 0)
			return 0;

		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
		hashmap.put('I', 1);
		hashmap.put('V', 5);
		hashmap.put('X', 10);
		hashmap.put('L', 50);
		hashmap.put('C', 100);
		hashmap.put('D', 500);
		hashmap.put('M', 1000);

		if (s.length() == 1)
			return hashmap.get(s.charAt(0));
		int ans = 0, i = 0;
		for (; i < s.length() - 1; i++) {
			if (5 * hashmap.get(s.charAt(i)) == hashmap.get(s.charAt(i + 1))
					|| 10*hashmap.get(s.charAt(i)) == hashmap.get(s.charAt(i + 1)))
				ans -= hashmap.get(s.charAt(i));
			else
				ans += hashmap.get(s.charAt(i));
		}
		ans += hashmap.get(s.charAt(i));
		return ans;
	}
	
	public static void main(String []args){
		Solution s=new Solution();
		String str=new String("DCXXI");
		System.out.println(s.romanToInt(str));
	}
}
