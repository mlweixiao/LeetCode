package P12_Integer_to_Roman;

public class Solution {
	public String intToRoman(int num) {
		StringBuffer ans = new StringBuffer();
		int number, i = 0;
		char ch[] = new char[] { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		while (num != 0) {
			number = num % 10;
			switch (number) {
			case 1:
			case 2:
			case 3: {
				for (int j = 0; j < number; j++)
					ans.insert(0, ch[2 * i]);
				break;
			}
			case 4: {
				ans.insert(0, ch[2 * i + 1]);
				ans.insert(0, ch[2 * i]);
				break;
			}
			case 5: {
				ans.insert(0, ch[2 * i + 1]);
				break;
			}
			case 6:
			case 7:
			case 8: {
				for (int j = 0; j < number - 5; j++)
					ans.insert(0, ch[2 * i]);
				ans.insert(0, ch[2 * i + 1]);
				break;
			}
			case 9: {
				ans.insert(0, ch[2 * i + 2]);
				ans.insert(0, ch[2 * i]);
				break;
			}
			}
			num = num / 10;
			i++;
		}
		return ans.toString();
	}
}
