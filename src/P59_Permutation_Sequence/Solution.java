package P59_Permutation_Sequence;

public class Solution {
	
	private void nextPermutation(int[] num) {
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
		// swap the cur and the last one(bigger than it)
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
			temp = num[i];
			num[i] = num[num.length - i + cur];
			num[num.length - i + cur] = temp;
		}
	}
	
    public String getPermutation(int n, int k) {
        int [] temp=new int[n];
        StringBuffer s=new StringBuffer("");
        
        for(int i=0;i<n;i++){
        	temp[i]=i+1;
        }
        for(int i=1;i<k;i++){
        	nextPermutation(temp);
        }
        
        for(int i=0;i<n;i++){
        	s.append(temp[i]);
        }
        return s.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		System.out.println(s.getPermutation(3, 5));
	}

}
