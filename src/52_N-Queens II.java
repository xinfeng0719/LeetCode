public class Solution {
    int count;
    public int totalNQueens(int n) {
        int[] col = new int[n];
        count=0;
        dfs(col,0,n);
        return count;
    }
    public void dfs(int[] col, int curRow,int n){
        if(curRow==n){
            count++;
            return;
        }
        for(int val=0;val<n;val++){
            col[curRow]=val;
            if(checkValid(col,curRow)) dfs(col,curRow+1,n);
        }
    }
    public boolean checkValid(int[] col,int curRow){
        for(int j=0;j<curRow;j++){
            if(col[curRow]==col[j]||(Math.abs(col[curRow]-col[j])==(curRow-j))) return false;
        }
        return true;
    }
}
