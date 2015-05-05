package P91_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashMap<List<Integer>,Long> hashmap=new HashMap<List<Integer>,Long>();
		if(num==null) return result;
		
		Arrays.sort(num);
		int len=num.length;
		for(long i=0;i<(1<<len);i++){
			
			String str=Long.toBinaryString(i);
			List<Integer> list=new ArrayList<Integer>();
			for(int j=str.length()-1;j>=0;j--){
				if(str.charAt(j)=='1') list.add(num[str.length()-1-j]);
			}
			if(!hashmap.containsKey(list)){
				hashmap.put(list, i);
				result.add(list);
			}
		}
		return result;
	}
}
