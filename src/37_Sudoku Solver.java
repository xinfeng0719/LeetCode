public class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null||board.length==0) return;
        dfs(board);
        return;
    }
    public boolean dfs(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    //continue add value from 1 to 9, only continue if check valid is true
                    for(char val='1';val<='9';val++){
                        if(checkValid(board,i,j,val)){
                            board[i][j]=val;
                            if(dfs(board)) return true;
                            else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;//
                }
                
            }
        }
        return true;
    }
    public boolean checkValid(char[][] board,int i,int j,char val){
        for(int row=0;row<9;row++){
            if(board[row][j]==val) return false;
        }
        for(int col=0;col<9;col++){
            if(board[i][col]==val) return false;
        }
        for(int row=(i/3)*3;row<(i/3)*3+3;row++){
            for(int col=(j/3)*3;col<(j/3)*3+3;col++){
                if(board[row][col]==val) return false;
            }
        }
        return true;
    }
}
