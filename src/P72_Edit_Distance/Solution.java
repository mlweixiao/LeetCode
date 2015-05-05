package P72_Edit_Distance;


public class Solution {
//	Time Limit Exceeded,Last executed input:	"dinitrophenylhydrazine", "acetylphenylhydrazine"
//	public int minDistance(String word1 ,int index1, String word2,int index2) {
//		if(index1>=word1.length()&&index2>=word2.length()){
//			return 0;
//		}
//		else if(index1>=word1.length()){
//			return word2.length()-index2;
//		}
//		else if(index2>=word2.length()){
//			return word1.length()-index1;
//		}
//		if(word1.charAt(index1)==word2.charAt(index2)){
//			return minDistance(word1,index1+1,word2,index2+1);
//		}else {
//			int res1=1+Math.min(minDistance(word1,index1+1,word2,index2),minDistance(word1,index1,word2,index2+1));
//			int res2=1+minDistance(word1,index1+1,word2,index2+1);
//			return Math.min(res1, res2);
//		}
//	}
//	
//	public int minDistance(String word1, String word2) {
//		return minDistance(word1 , 0, word2, 0);
//	}
	public int minDistance(String word1, String word2) {
		int [][]distance=new int [word1.length()+1][word2.length()+1];
		for(int i=1;i<=word1.length();distance[i][0]=i,i++);
		for(int i=1;i<=word2.length();distance[0][i]=i,i++);
		for(int i=1;i<=word1.length();i++){
			for(int j=1;j<=word2.length();j++){
				if(word1.charAt(i-1)==word2.charAt(j-1)){
					distance[i][j]=distance[i-1][j-1];
				}else{
					distance[i][j]=1+Math.min(Math.min(distance[i-1][j], distance[i][j-1]),distance[i-1][j-1]);
				}
			}
			//System.out.println(Arrays.deepToString(distance));
		}
		return distance[word1.length()][word2.length()];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "sea";
		String str2 = "ate";
		Solution s = new Solution();
		System.out.println(s.minDistance(str1, str2));
	}

}
