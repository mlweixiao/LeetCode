package P39_Combination_Sum_II;

import java.util.*;

public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
		int previos=-1;
		for(int i=level;i<candidates.length;i++){
			// 如果上一轮循环没有选candidates[i]，则本次循环就不能再选candidates[i]，
			// 确保candidates[i] 最多只用一次
			if(previos==candidates[i]) continue;
			if(gap<candidates[i]) return;
			previos=candidates[i];
			intermediate.add(candidates[i]);
			dfs(candidates,gap-candidates[i],i+1,intermediate,result);
			intermediate.remove(intermediate.size()-1);
		}
	}
}
