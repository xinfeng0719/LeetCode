public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length==0) return false;
        if(word==null||word.length()==0) return true;
        boolean[][] visitBoard = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(dfs(board,visitBoard,word,0,i,j)) return true;
            }
        }
        return false;
        
    }
    public boolean dfs(char[][] board, boolean[][] visitBoard,String word, int curIndex,int i,int j){
        if(curIndex==word.length()) return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length||visitBoard[i][j]) return false;
        if(word.charAt(curIndex)!=board[i][j]) return false;//alrady visit or not equal return false
        visitBoard[i][j]=true;
        //
        boolean res = dfs(board,visitBoard,word,curIndex+1,i,j-1)||dfs(board,visitBoard,word,curIndex+1,i,j+1)||dfs(board,visitBoard,word,curIndex+1,i-1,j)||dfs(board,visitBoard,word,curIndex+1,i+1,j);
        //
        visitBoard[i][j]=false;
        return res;
        
    }
}
