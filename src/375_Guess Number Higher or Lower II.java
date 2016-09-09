public class Solution {
    public int getMoneyAmount(int n) {
        if(n==1) return 0;
        int[][] dp = new int[n+1][n+1];// from i to j, how much money are needed in worst case.
        for(int diff=1;diff<n;diff++){
            for(int i=0;i+diff<=n;i++){
                int j = i+diff;
                dp[i][j] = Integer.MAX_VALUE;
                //choose k, then the question is divided into 2 subproblems
                //but we are only need to care about the worst case(that's why we use Math.max)
                //use condition for not using too many if-else cluse.
                for(int k=i;k<=j;k++){
                    dp[i][j] = Math.min(dp[i][j],k+Math.max(k-1>=i?dp[i][k-1]:0,j>=k+1?dp[k+1][j]:0));
                }
            }
        }
        return dp[1][n];
    }
}
