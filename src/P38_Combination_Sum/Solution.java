package P38_Combination_Sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Arrays.sort(candidates);
		LinkedList<Integer> intermediate=new LinkedList<Integer>();
		dfs(candidates,target,0,intermediate,result);
		return result;
	}

	private void dfs(int[] candidates,int gap,int level,List<Integer> intermediate,List<List<Integer>> result){
		if(gap==0){	
			result.add(new LinkedList<Integer>(intermediate));
			return;
		}
		for(int i=level;i<candidates.length;i++){
			if(gap<candidates[i]) return;
			intermediate.add(candidates[i]);
			dfs(candidates,gap-candidates[i],i,intermediate,result);
			intermediate.remove(intermediate.size()-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates=new int []{1};
		int target=1;
		Solution s=new Solution();
		List<List<Integer>> result =s.combinationSum(candidates, target);
		for(List<Integer> list:result)
			System.out.println(list);
	}

}
