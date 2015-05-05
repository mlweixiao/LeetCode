package P127_Word_Ladder_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  private ArrayList<ArrayList<String>> result;
  private Map<String, List<String>> nextMap;

  public ArrayList<ArrayList<String>> findLadders(String start, String end,
      Set<String> dict) {
	  HashMap<Integer, List<String>> level=new HashMap<Integer,List<String>>();
	  ArrayList<String> al=new ArrayList<String>();
	  al.add(start);
	  level.put(0,al);
	  
	  return result;
  }

  private void getPaths(String currentWord, ArrayList<String> list, int level) {
    if (currentWord.equals(end)) {
      result.add(new ArrayList<String>(list));
    } else if (level > 0) {
      List<String> parentsSet = nextMap.get(currentWord);
      for (String parent : parentsSet) {
        list.add(parent);
        getPaths(parent, list, level - 1);
        list.remove(list.size() - 1);
      }
    }
  }


	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		String[] str1 = new String[] {"ted","tex","red","tax","tad","den","rex","pee" };
		String[] str2 = new String[] { "red", "tax" };
		for (int i = 0; i < str1.length; i++) {
			hs.add(str1[i]);
		}
		Solution s = new Solution();
		String start = str2[0];
		String end = str2[1];
		System.out.println(s.findLadders(start, end, hs).toString());
	}
}
