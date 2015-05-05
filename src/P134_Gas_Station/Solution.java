package P134_Gas_Station;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==0) return -1;
    	int sub;
    	int sum=0;
    	int temp=0;
    	int result=0;
    	for(int i=0;i<gas.length;i++){
    		sub=gas[i]-cost[i];
    		sum+=sub;
    		temp+=sub;
    		if(temp<0){
    			temp=0;
    			result=i+1;
    		}
    	}
    	if(sum<0) return -1;
    	else return result;
    }
}