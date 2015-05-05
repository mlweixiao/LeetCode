package P123_Best_Time_to_Buy_and_Sell_Stock_III;

import java.util.ArrayList;

public class Solution {
    public int maxsum(ArrayList<Integer> num,int start,int end) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = start; i <=end; i++) {
			sum += num.get(i);
			if (max < sum) max = sum;
			if (sum <= 0) sum = 0;
		}
		return max>0?max:0;
	}
	
	public int maxProfit(int[] prices) {
		if (prices.length==0||prices.length==1) return 0;
		
		ArrayList<Integer>  sub = new ArrayList<Integer>();
		boolean flag=false;
		
		for (int i = 0; i < prices.length-1; i++){
			if(prices[i+1]-prices[i]>=0||flag){
				flag=true;
			    sub.add(prices[i + 1] - prices[i]);
			}	
		}
		for (int i = prices.length-2; 0 <= i; i--){
			if(!sub.isEmpty()&&prices[i+1]-prices[i]<0) sub.remove(sub.size()-1);
			else break;	
		}
		
		if(sub.size()==0) return 0;
		
		int result=maxsum(sub,0,sub.size()-1);
		for (int i=0;i<sub.size();i++){
			if(sub.get(i)<0){
				int temp=maxsum(sub,0,i-1)+maxsum(sub,i+1,sub.size()-1);
				result=result>temp?result:temp;
			}
		}
		
		return result;
	}
}
