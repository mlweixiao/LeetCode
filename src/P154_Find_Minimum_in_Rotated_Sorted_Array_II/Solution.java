package P154_Find_Minimum_in_Rotated_Sorted_Array_II;

import java.util.Arrays;

public class Solution {
	public int findMin_1(int[] num) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			if (min > num[i])
				min = num[i];
		}
		return min;
	}
	public int findMin_2(int[] num) {
		Arrays.sort(num);
		return num[0];
	}
	public int findMin(int[] num) {
		return minFind(num, 0, num.length - 1);
	}

	private int minFind(int[] num, int begin, int end) {
		int middle = (begin + end) / 2;
		if (begin == end) {
			return num[begin];
		} else if (end == begin + 1) {
			return Math.min(num[begin], num[end]);
		} else if (end == begin + 2) {
			return Math.min(Math.min(num[begin], num[begin + 1]), num[end]);
		}
		if (num[begin] == num[end]) {
			return Math.min(minFind(num, begin, middle),minFind(num, middle, end));
		}
		else if (num[middle] < num[begin] && num[middle] <= num[end]) {
			return minFind(num, begin, middle);
		} else if (num[begin] <= num[middle] && num[end] < num[middle]) {
			return minFind(num, middle, end);
		} else if (num[begin] < num[middle] && num[middle] <= num[end]) {
			return minFind(num, begin, middle);
		}else if (num[begin] <= num[middle] && num[middle] < num[end]) {
			return minFind(num, begin, middle);
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] { 3,1,1, 3 };
		Solution s = new Solution();
		System.out.println(s.findMin(num));
	}

}
