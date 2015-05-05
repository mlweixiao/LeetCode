package P51_N_Queens_II;

import java.util.LinkedList;
import java.util.List;
class Solution_1 {
	public int totalNQueens(int n) {
		int[] result = new int[] { 0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724,
				2680, 14200, 73712, 365596, 2279184, 14772512, 95815104,
				666090624 };
		return result[n];
	}	
}
class Solution_2{
	public static int num = 0;

	private boolean isValid(List<Integer> al) {
		int column = al.get(al.size() - 1);
		for (int i = 0; i < al.size() - 1; i++) {
			if (column == al.get(i)
					|| Math.abs(column - al.get(i)) == Math.abs(al.size() - 1
							- i)) {
				return false;
			}
		}
		return true;
	}

	private void search(int n, List<Integer> al, int col) {
		if (col > n) {
			num++;
		} else {
			for (int j = 0; j < n; j++) {
				al.add(j);
				if (isValid(al)) {
					search(n, al, col + 1);
				}
				al.remove(al.size() - 1);
			}
		}
	}

	public int totalNQueens(int n) {
		num = 0;
		search(n, new LinkedList<Integer>(), 1);
		return num;
	}

}
public class Solution {
    // sum用来记录皇后放置成功的不同布局数；upperlim用来标记所有列都已经放置好了皇后。
    static int counter = 0;
    static long upperlim = 1;
    // 试探算法从最右边的列开始，函数带三个参数row、ld和rd，分别表示在纵列和两个对角线方向的限制条件下这一行的哪些地方不能放
    void search(long row, long ld, long rd) {
        if (row != upperlim) {
            // row，ld，rd进行“或”运算，求得所有可以放置皇后的列,对应位为0，
            // 然后再取反后“与”上全1的数，来求得当前所有可以放置皇后的位置，对应列改为1
            // 也就是求取当前哪些列可以放置皇后
            long pos = upperlim & ~(row | ld | rd);
            while (pos != 0) { // 0 -- 皇后没有地方可放，回溯
                // 拷贝pos最右边为1的bit，其余bit置0
                // 也就是取得可以放皇后的最右边的列
                long p = pos & -pos;//相当于p = pos & (~pos + 1)

                // 将pos最右边为1的bit清零
                // 也就是为获取下一次的最右可用列使用做准备，
                // 程序将来会回溯到这个位置继续试探
                pos -= p;//可采用pos^=p;

                // row + p，将当前列置1，表示记录这次皇后放置的列。
                // (ld + p) << 1，标记当前皇后左边相邻的列不允许下一个皇后放置。
                // (ld + p) >> 1，标记当前皇后右边相邻的列不允许下一个皇后放置。
                // 此处的移位操作实际上是记录对角线上的限制，只是因为问题都化归
                // 到一行网格上来解决，所以表示为列的限制就可以了。显然，随着移位
                // 在每次选择列之前进行，原来N×N网格中某个已放置的皇后针对其对角线
                // 上产生的限制都被记录下来了
                search(row + p, (ld + p) << 1, (rd + p) >> 1);
                //可采用 search(row | p, (ld | p) << 1, (rd | p) >> 1);
            }
        } else {
            // row的所有位都为1，即找到了一个成功的布局，回溯
            counter++;
        }
    }
    public int totalNQueens(int n) {
        counter = 0;
        upperlim = (1 << n) - 1;
        search(0, 0, 0);
        return counter;
    }


	public static void main(String[] args) {
		Solution s = new Solution();
		//System.out.print(s.totalNQueens(16));
		for (int i = 1; i <17; i++)
			System.out.print(s.totalNQueens(i) + " ");
	}

}
