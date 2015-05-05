package P56_Insert_Interval;

import java.util.*;

/**
 * Definition for an interval.
 */
class Interval {
      int start;
     int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

 
 @SuppressWarnings("rawtypes")
class MyComprator implements Comparator {
	public int compare(Object arg0, Object arg1) {
		Interval t1 = (Interval) arg0;
		Interval t2 = (Interval) arg1;
		if (t1.start == t2.start && t1.end == t2.end) return 0;
		if (t1.start != t2.start)
			return t1.start > t2.start ? 1 : -1;
		else
			return t1.end > t2.end ? 1 : -1;
	}
}

public class Solution {
    @SuppressWarnings("unchecked")
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
      	intervals.add(newInterval);

		Interval[] arr = intervals.toArray(new Interval[intervals.size()]);
		List<Interval> result=new ArrayList<Interval>();		
		
		Arrays.sort(arr, new MyComprator());
		Interval mover = arr[0];
		
		for(int i=1;i<arr.length;i++){
			if(mover.end<arr[i].start) {
				result.add(mover);
		        mover = arr[i];
			}else{
				mover.end = Math.max(mover.end,arr[i].end);
			}
		}
		result.add(mover);
		
		return result;  
    }
}