package P149_Max_Points_on_a_Line;

import java.util.Collection;
import java.util.HashMap;

/**
 * Definition for a point.
 */
  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }

public class Solution {
	public int maxPoints(Point[] points) {
		if (points.length < 3)
			return points.length;
		int result = 0;
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		Collection<Integer> set;
		for (int i = 0; i < points.length; i++) {
			int duplicate = 0;
			for (int j = 0; j < points.length; j++) {
				double k;
				if (i == j)continue;
				if(points[i].x==points[j].x&& points[i].y==points[j].y){
					duplicate++;
					continue;
				}else if(points[i].x==points[j].x&& points[i].y!=points[j].y){
					k=Double.MAX_VALUE;
				}else{
					k=(double)(points[i].y-points[j].y)/(points[i].x-points[j].x);
				}
				if(map.get(k)==null){
					map.put(k,2);
				}else{
					int value=map.get(k).intValue();
					value++;
					map.put(k, value);
				}
			}
			set=map.values();
			if(set.isEmpty()){
				result=duplicate+1;
			}
			for(int v: set){
				if(result<(v+duplicate)){
					result=v+duplicate;
				}
			}
		}
		return result;
	}
}
