package P75_Sort_Colors;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	public void sortColors_1(int[] A) {
		 int current = 0;
	      int end = A.length-1;
	      int begin = 0;
	      int temp=-1;
		while(begin<end){
			if(A[current]==0){
				temp=A[begin];
				A[begin]=A[current];
				A[current]=temp;
				begin++;
				current++;
			}else if(A[current]==1){
				current++;
			}else {
				temp=A[end];
				A[end]=A[current];
				A[current]=temp;
				end--;
			}
		}
	}
	public void sortColors(int[] A) {
		if (A == null || A.length < 2) return;
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		hashmap.put(0, 0);
		hashmap.put(1, 0);
		hashmap.put(2, 0);

		for (int i = 0; i < A.length; i++) {
			int value = hashmap.get(A[i]);
			value++;
			hashmap.put(A[i], value);
		}
		
		Arrays.fill(A,0,hashmap.get(0),0);
		Arrays.fill(A,hashmap.get(0),hashmap.get(0)+hashmap.get(1),1);
		Arrays.fill(A,hashmap.get(0)+hashmap.get(1),A.length,1);
		//for(int i=0;i<hashmap.get(0);i++,A[i]=0);
		//for(int i=hashmap.get(0);i<hashmap.get(0)+hashmap.get(1);i++,A[i]=1);
		//for(int i=hashmap.get(1)+hashmap.get(0);i<A.length;i++,A[i]=2);
		
	}
}
