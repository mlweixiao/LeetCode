package P67_Plus_One;

public class Solution {
	public int[] plusOne(int[] digits) {
		int[] ans;
		int tmp = 1;
		boolean flag = false;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 9) {
				flag = true;
				break;
			}
		}
		if (flag) {
			ans = new int[digits.length];
			for (int i = digits.length - 1; 0 <= i; i--) {
				ans[i] = (tmp + digits[i]) % 10;
				if (tmp + digits[i] >= 10) {
					tmp = 1;
				} else {
					tmp = 0;
				}
			}
		} else {
			ans = new int[digits.length + 1];
			ans[0] = 1;
		}
		return ans;
	}
}
