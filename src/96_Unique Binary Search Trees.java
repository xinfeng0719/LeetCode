//DP problem
//start case:dp[0]=1, dp[1]=1,dp[2]=2
//no node->0 case, 1 node -> 1 case, 2 node -> 2 case
//how to cal dp[3], as we will choose one node as root, then we have 2 node in manupilating. 
//2 node in left tree 0 node in the right tree, 1 node in the left 1 node in the right, or 0 node in the left and 2 node in the right
//Depending on this, dp[4] can be calculated in the same way.
public class Solution {
    public int numTrees(int n) {
        if(n<=2) return n;
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            //from 3 node to n node case
            for(int j=1;j<=i;j++){
                //if we have i node, the extreme case is we have i-j node in one side and 0 node in the otherside
                dp[i]+=(dp[i-j]*dp[j-1]);
            }
        }
        return dp[n];
        
    }
}
