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
    // sum������¼�ʺ���óɹ��Ĳ�ͬ��������upperlim������������ж��Ѿ����ú��˻ʺ�
    static int counter = 0;
    static long upperlim = 1;
    // ��̽�㷨�����ұߵ��п�ʼ����������������row��ld��rd���ֱ��ʾ�����к������Խ��߷����������������һ�е���Щ�ط����ܷ�
    void search(long row, long ld, long rd) {
        if (row != upperlim) {
            // row��ld��rd���С������㣬������п��Է��ûʺ����,��ӦλΪ0��
            // Ȼ����ȡ�����롱��ȫ1����������õ�ǰ���п��Է��ûʺ��λ�ã���Ӧ�и�Ϊ1
            // Ҳ������ȡ��ǰ��Щ�п��Է��ûʺ�
            long pos = upperlim & ~(row | ld | rd);
            while (pos != 0) { // 0 -- �ʺ�û�еط��ɷţ�����
                // ����pos���ұ�Ϊ1��bit������bit��0
                // Ҳ����ȡ�ÿ��ԷŻʺ�����ұߵ���
                long p = pos & -pos;//�൱��p = pos & (~pos + 1)

                // ��pos���ұ�Ϊ1��bit����
                // Ҳ����Ϊ��ȡ��һ�ε����ҿ�����ʹ����׼����
                // ����������ݵ����λ�ü�����̽
                pos -= p;//�ɲ���pos^=p;

                // row + p������ǰ����1����ʾ��¼��λʺ���õ��С�
                // (ld + p) << 1����ǵ�ǰ�ʺ�������ڵ��в�������һ���ʺ���á�
                // (ld + p) >> 1����ǵ�ǰ�ʺ��ұ����ڵ��в�������һ���ʺ���á�
                // �˴�����λ����ʵ�����Ǽ�¼�Խ����ϵ����ƣ�ֻ����Ϊ���ⶼ����
                // ��һ������������������Ա�ʾΪ�е����ƾͿ����ˡ���Ȼ��������λ
                // ��ÿ��ѡ����֮ǰ���У�ԭ��N��N������ĳ���ѷ��õĻʺ������Խ���
                // �ϲ��������ƶ�����¼������
                search(row + p, (ld + p) << 1, (rd + p) >> 1);
                //�ɲ��� search(row | p, (ld | p) << 1, (rd | p) >> 1);
            }
        } else {
            // row������λ��Ϊ1�����ҵ���һ���ɹ��Ĳ��֣�����
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
