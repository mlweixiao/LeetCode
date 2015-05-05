package P126_Word_Ladder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
//import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
	// private int[][] getNumOfDifferent(HashMap<String ,Integer> hm) {
	// Iterator<String> it1=hm.keySet().iterator();
	// int[][] numofdifferent = new int[hm.size()][hm.size()];
	//
	// while(it1.hasNext()) {
	// Iterator<String> it2=it1;
	// String str1=(String) it1.next();
	// while(it2.hasNext()) {
	// String str2=(String) it2.next();
	// for (int i = 0; i < str1.length(); i++) {
	// if (str1.charAt(i) != str2.charAt(i)) {
	// numofdifferent[hm.get(str1)][hm.get(str2)]++;
	// numofdifferent[hm.get(str2)][hm.get(str1)]++;
	// }
	// }
	// }
	// }
	// return numofdifferent;
	// }
	// private int getMinLadderLength(){
	//
	// }
	// public int ladderLength(String start, String end, Set<String> dict) {
	// HashMap<String ,Integer> hm=new HashMap<String ,Integer> ();
	// hm.put(start, 0);
	// hm.put(end,dict.size()+1);
	// Iterator<String> it=dict.iterator();
	// int i=1,j;
	// while(it.hasNext()){
	// hm.put(it.next(),i);
	// i++;
	// }
	//
	// int[][] numofdifferent = getNumOfDifferent(hm);
	// for(i=0;i<numofdifferent.length;i++){
	// for(j=0;j<numofdifferent.length;j++){
	//
	// }
	// }
	// return 0;
	// }

	public int ladderLength(String start, String end, Set<String> dict) {
		if(start==end)return 0;
		
		LinkedList<String> queue=new LinkedList<String>();
		HashMap<String ,Integer> dist=new HashMap<String,Integer>();
		queue.add(start);
		dist.put(start,1);
		while(!queue.isEmpty()){
			String head=queue.poll();
			for(int i=0;i<head.length();i++){
				for(char c='a';c<='z';c++){
					if(head.charAt(i)==c) continue;
					StringBuffer sb=new StringBuffer(head);
					sb.setCharAt(i, c);
					if(sb.toString().equals(end)) return dist.get(head)+1;
					if(dict.contains(sb.toString())&&!dist.containsKey(sb.toString())){
						dist.put(sb.toString(), dist.get(head)+1);
						queue.add(sb.toString());
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs=new HashSet<String>();
		String [] str=new String []{"hot","dog","dot"};
		hs.addAll(Arrays.asList(str));
//		for(int i=0;i<str.length;i++){
//			hs.add(str[i]);
//		}
		Solution s=new Solution();
		String start=new String("hot");
		String end =new String ("dog");
		System.out.println(s.ladderLength(start, end, hs));
	}

}
