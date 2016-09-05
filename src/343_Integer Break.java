public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        for(int i=1;i<=n;i++){
            int m=0;
            for(int j=1;j<=i/2;j++){
                int left = dp[i];
                int right = dp[i-j];
                m = Integer.max(m,left*right);//case one, left part * right part
                m = Integer.max(m,j*right);//case 2, left number* right part
                m = Integer.max(m,left*(i-j));//case 3 left part*right number
                m = Integer.max(m,j*(i-j));
            }
            dp[i]=m;
        }
        return dp[n];
        
    }
}
