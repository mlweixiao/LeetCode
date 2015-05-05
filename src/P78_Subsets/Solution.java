package P78_Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(S==null) return result;
		
		Arrays.sort(S);
		int len=S.length;
		for(long i=0;i<(1<<len);i++){
			
			String str=Long.toBinaryString(i);
			List<Integer> list=new ArrayList<Integer>();
			for(int j=str.length()-1;j>=0;j--){
				if(str.charAt(j)=='1') list.add(S[str.length()-1-j]);
			}
			result.add(list);
		}
		
		return result;
	}
}