package P46_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<List<Integer>> permuteUnique(int[] num) {
		
    	
		Arrays.sort(num);
		int [] temparray=new int [num.length];
		System.arraycopy(num, 0, temparray, 0, num.length);
		
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(;;){
			// 注意不能使用list.addAll(Arrays.asList(num));
			// 也不能使用Collection.addAll(list ,num);
			// Arrays.asList() 返回java.util.Arrays$ArrayList，
			// 而不是ArrayList。Arrays$ArrayList和ArrayList都是继承AbstractList，
			//remove，add等method在AbstractList中是默认throw
			// UnsupportedOperationException而且不作任何操作。
			
			//最根本的的原因是num是int [] 并非Integer []
			List list = new ArrayList<Integer>();
			for(int i=0;i<num.length;i++){
				list.add(num[i]);
			}
			result.add(list);
			nextPermutation(num);
			if(Arrays.equals(num, temparray)) break;
		}
		return result;        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num=new int []{1,1,3};
		Solution s=new Solution ();
		List<List<Integer>> result=s.permuteUnique(num);
		System.out.println(result);
	}
}
