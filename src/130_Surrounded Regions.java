public class Solution {
    public void solve(char[][] board) {
        //key is remaining "O" point has a path to "O" point on the edge 
        //first call dfs, go thorugh whole block
        //then flip all "O" to "X", all "Y" to "O"
        if(board==null||board.length==0) return;
        int row = board.length;
        int col = board[0].length;
        if(col>1&&row>1){
            for(int i=0;i<col-1;i++){
                //top
                if(board[0][i]=='O') search(board,0,i);
                //bottom
                if(board[row-1][i]=='O') search(board,row-1,i);//
            }
            for(int i=0;i<row;i++){
                //left col
                if(board[i][0]=='O') search(board,i,0);
                //right col
                if(board[i][col-1]=='O') search(board,i,col-1);
            }
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(board[i][j]=='Y'){
                        board[i][j]='O';
                    }else{
                        board[i][j]='X';
                    }
                }
            }
        }
    }
    public void search(char[][] board,int i,int j){
        if(board[i][j]=='O'){
            board[i][j]='Y';//after visit it, we set its value, and then we will not need to cal the same thereafter
            //condition is our path shalln't on edge
            if(i>1){
                search(board,i-1,j);
            }
            if(i<board.length-1){
                search(board,i+1,j);
            }
            if(j>1){
                search(board,i,j-1);
            }
            if(j<board[0].length-1){
                search(board,i,j+1);
            }
        }
    }
}
