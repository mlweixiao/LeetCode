package P122_Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution {
    public int maxProfit(int[] prices) {
      if(prices.length==0||prices.length==1) return 0;
      int result=0;
      for(int i=1;i<prices.length;i++){
    	  if(prices[i]>prices[i-1]) result+=(prices[i]-prices[i-1]);
      }
      return result;
    }
}
