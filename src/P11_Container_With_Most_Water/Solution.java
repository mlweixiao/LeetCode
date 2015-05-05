package P11_Container_With_Most_Water;

public class Solution {
    public int maxArea(int[] height) {
    	if(height.length<1){
    		return 0;
    	}
    	int i=0;
    	int j=height.length-1;
    	int area=0;
    	int tmp;
    	while(i<j){    		
    		if(height[i]<height[j]){
    			tmp=height[i]*(j-i);
    			i++;
    		}else{
    			tmp=height[j]*(j-i);
    			j--;
    		}
    		if(area<tmp){
    			area=tmp;
    		}
    	}
        return area;
    }
}
