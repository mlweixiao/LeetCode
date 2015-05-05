package P50_N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution_1 {
	static int upperlim = 1;

	private void search(int l, int ld, int rd, List<Integer> list,
			List<String[]> result) {
		if (l != upperlim) {
			int pos = upperlim & (~(l | ld | rd));
			while (pos != 0) {
				int p = pos & -pos;
				int temp = p;
				int index = 0;
				while (temp != 1) {
					temp = temp >> 1;
					index++;
				}
				list.add(index);// 从0开始的
				pos ^= p;
				search(l | p, (ld | p) << 1, (rd | p) >> 1, list, result);
				list.remove(list.size() - 1);
			}
		} else {
			char[] temp = new char[list.size()];
			Arrays.fill(temp, '.');
			String[] str = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				StringBuilder sb = new StringBuilder(String.valueOf(temp));
				sb.setCharAt(list.get(i), 'Q');
				str[i] = sb.toString();
			}
			result.add(str);
		}
	}

	public List<String[]> solveNQueens(int n) {
		upperlim = (1 << n) - 1;
		List<String[]> result = new LinkedList<String[]>();
		search(0, 0, 0, new LinkedList<Integer>(), result);
		return result;
	}
}

public class Solution {
	public List<String[]> solveNQueens(int n) {
		List<String[]> result = new LinkedList<String[]>();
		search(result, n, new ArrayList<Integer>(), 1);
		return result;
	}

	private boolean isValid(List<Integer> list) {
		int column = list.get(list.size() - 1);
		for (int i = 0; i < list.size() - 1; i++) {
			if (column == list.get(i)
					|| Math.abs(column - list.get(i)) == Math.abs(list.size() - 1
							- i)) {
				return false;
			}
		}
		return true;
	}

	private void search(List<String[]> result, int n, List<Integer> list,
			int col) {
		if (col > n) {
			char[] temp = new char[n];
			Arrays.fill(temp, '.');
			String[] str = new String[n];
			for (int i = 0; i < list.size(); i++) {
				StringBuilder sb = new StringBuilder(String.valueOf(temp));
				sb.setCharAt(list.get(i), 'Q');
				str[i] = sb.toString();
			}
			result.add(str);
		} else {
			for (int j = 0; j < n; j++) {
				list.add(j);
				if (isValid(list)) {
					search(result, n, list, col + 1);
				}
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Solution_1 s = new Solution_1();
		int n = 8;
		List<String[]> result = s.solveNQueens(n);
		for (String[] str : result) {
			System.out.println(Arrays.toString(str));
		}

		System.out.println("\n" + result.size());
	}
}
