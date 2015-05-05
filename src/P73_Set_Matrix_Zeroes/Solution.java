package P73_Set_Matrix_Zeroes;

import java.util.Arrays;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int column=matrix[0].length;
        if(matrix==null||row<1) return ;
        boolean[] rowflag= new boolean[row];
        boolean[] colflag= new boolean[column];
        for(int i=0;i<row;i++){
        	for(int j=0;j<column;j++){
        		if(matrix[i][j]==0){
        			rowflag[i]=true;
        			colflag[j]=true;
        		}
        	}
        }
        for(int i=0;i<row;i++){
        	if(rowflag[i]){
        		Arrays.fill(matrix[i],0);
//        		for(int j=0;j<column;j++){
//        			matrix[i][j]=0;
//        		}
        	}
        }
        for(int i=0;i<column;i++){
        	if(colflag[i]){
        		for(int j=0;j<row;j++){
        			matrix[j][i]=0;
        		}
        	}
        }
    }
}
