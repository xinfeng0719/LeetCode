//basic
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}

//3 time loop use 2D dp
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dp[i][j]=0;
            }
        }
        for (int i=0;i<row;i++){
            if(obstacleGrid[i][0]!=1)
                dp[i][0]=1;
            else
                break;
        }
        for(int j=0;j<col;j++){
            if(obstacleGrid[0][j]!=1)
                dp[0][j]=1;
            else
                break;
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[row-1][col-1];
    }
}

//with obstacle,try use one dimision DP rather than 2-D array
//iterate each row and adds them up
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0]=1;
        for(int[] row:obstacleGrid){
            for(int i=0;i<width;i++){
                if(row[i]==1){
                    dp[i]=0;
                }else if(i>0){
                    dp[i]+=dp[i-1];
                }
            }
        }
        return dp[width-1];
    }
}
