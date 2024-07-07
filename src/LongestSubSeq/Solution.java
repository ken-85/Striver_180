package LongestSubSeq;
import java.util.*;

public class Solution {
    static Scanner sc=new Scanner(System.in);
	public int[][] lcs(String s, String t) {
		//Your code goes here
		int m=s.length();
		int n=t.length();
		int[][] dp=new int[m+1][n+1];
		
		for(int j=0; j<=n; j++) dp[0][j]=0;
		for(int i=0; i<=m; i++) dp[i][0]=0;

		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
				else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}

		return dp;
    }
    
    public String find(String s, String t){
        int[][] dp=new int[s.length()+1][t.length()+1];
        dp=lcs(s,t);
        int len=dp[s.length()][t.length()];
        String ans="";
        int ind=len-1;
        int i=s.length();
        int j=t.length();
        while(i>0 && j>0){
            if(s.charAt(i-1)==t.charAt(j-1)){
                ans+=s.charAt(i-1);
                ind--;
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args){
        System.out.println("Enter first String:");
        String s=sc.nextLine();
        System.out.println("Enter second String:");
        String t=sc.nextLine();
        Solution obj=new Solution();
        String res=obj.find(s,t);
        System.out.println(res);
        
    }
}
