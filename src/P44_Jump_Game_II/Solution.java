package P44_Jump_Game_II;

class Counter {
	public static int counter;
}

public class Solution {
	public int jump(int[] A) {
		Counter.counter = 0;
		return jump(A, A.length - 1);
	}

	private int jump(int[] A, int end) {
		int i = 0;
		for (; i < end; i++) {
			if (i + A[i] >= end) {
				Counter.counter++;
				break;
			}
		}
		if (i == 0)
			return Counter.counter;
		jump(A, i);
		return Counter.counter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[] { 2, 1 };
		Solution s = new Solution();
		System.out.println(s.jump(A));
	}

}
