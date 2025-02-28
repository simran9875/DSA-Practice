package LeetCode6;

public class Shortest_Common_Supersequence {
    public static String shortestCommonSupersequence(String str1, String str2) {
    	int m = str1.length(); int n = str2.length();
    	int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                	dp[i][j]=1+dp[i-1][j-1];
                }else {
                	dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }int i= m, j=n;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0) {
        	if(str1.charAt(i-1)==str2.charAt(j-1)) {
        		sb.append(str1.charAt(i-1));
        		i--; j--;
        	}else if(dp[i - 1][j] > dp[i][j - 1]) {
        		sb.append(str1.charAt(i-1));
        		i--;
        	}else {
        		sb.append(str2.charAt(j-1));
        		j--;
        	}
        }
        while(i>0) {
        	sb.append(str1.charAt(i-1));
        	i--;
        }
        while(j>0) {
        	sb.append(str2.charAt(j-1));
        	j--;
        }
        return sb.reverse().toString();
    }

	public static void main(String[] args) {
		String s1 ="abac";
		String s2= "cab";
		System.out.println(shortestCommonSupersequence(s1,s2));

	}

}
