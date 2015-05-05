package P1_Two_Sum;

import java.util.Arrays;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int[] ans = new int[2];
		int[] copy = numbers.clone();
		Arrays.sort(copy);
		int num = 0;
		int i,j;

		for(i=0,j=copy.length - 1;i != j;) {
			if ((copy[i] + copy[j]) == target) {
				num = copy[i];
				break;
			} else if (copy[i] + copy[j] > target) j--;
			else i++;
		}
		for (i = 0, j = 0; i < numbers.length; i++) {
			if (numbers[i] == num || numbers[i] == (target - num)) {
				ans[j] = i + 1;
				j++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] a = new int[] { 2, 7, 11, 15 };
		int target = 9;
		int[] result = s.twoSum(a, target);
		System.out.println(result[0] + " " + result[1]);
	}
}
