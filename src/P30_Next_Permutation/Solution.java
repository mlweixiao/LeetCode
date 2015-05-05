package P30_Next_Permutation;

import java.util.Arrays;

public class Solution {
	public void nextPermutation(int[] num) {
		int i;
		int cur = -1;
		int temp;
		// find the last increase sequence
		for (i = num.length - 1; i >= 1; i--) {
			if (num[i] > num[i - 1]) {
				cur = i - 1;
				break;
			}
		}

		// if the increase sequence exists,
		//swap the cur and the last one(bigger than it)
		if (cur != -1) {
			for (i = num.length - 1; i > cur; i--) {
				if (num[i] > num[cur]) {
					temp = num[cur];
					num[cur] = num[i];
					num[i] = temp;
					break;
				}
			}
		}

		for (i = cur + 1; 2 * i <= cur + num.length - 1; i++) {
			temp=num[i];
			num[i]=num[num.length-i+cur];
			num[num.length-i+cur]=temp;
		}
	}
	
	public static void main(String []args){
		Solution s=new Solution();
		int [] num=new int[]{1,3,2};
		s.nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}
}
