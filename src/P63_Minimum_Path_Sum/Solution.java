package P63_Minimum_Path_Sum;

public class Solution {
    public int minPathSum(int[][] grid) {
    	int i,j,min;
    	
    	for(i=1;i<grid.length;i++){
    		grid[i][0]+=grid[i-1][0];
    	}
    	for(i=1;i<grid[0].length;i++){
    		grid[0][i]+=grid[0][i-1];
    	}
    	
        for(i=1;i<grid.length;i++){
        	for(j=1;j<grid[0].length;j++){
        		min=grid[i-1][j]<grid[i][j-1]?grid[i-1][j]:grid[i][j-1];
        		grid[i][j]+=min;
        	}
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
