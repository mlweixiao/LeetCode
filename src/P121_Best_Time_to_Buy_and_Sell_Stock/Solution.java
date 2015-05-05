package P121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
	public int maxsum(int [] num){
		int sum=0;
		int max=0;
		for(int i=0;i<num.length;i++){
			sum+=num[i];
			if(sum<0) sum=0;
			if(max<sum) max=sum;
		}
		return max;
	}
    public int maxProfit(int[] prices) {
      if(prices.length==0||prices.length==1) return 0;
      int [] sub=new int [prices.length-1];
      for(int i=0;i<sub.length;i++){
    	  sub[i]=prices[i+1]-prices[i];
      }
      return maxsum(sub);
    }
}
