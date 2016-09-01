//straight forward, determine every column, row, and 3*3 blocks
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //use Hashtable for determine, if we can successuflly add to the hashtable
        //however, for increasing efficiency, try use int[] array instead of hashtable
        for(int i=0;i<9;i++){
            int[] row = new int[10];
            int[] col = new int[10];
            int[] block = new int[10];
            for(int j=0;j<9;j++){
                char v = board[i][j];
                if(v!='.'){
                    if(row[v-'0']==1){
                        return false;
                    }
                    row[v-'0']=1;
                }
                v = board[j][i];
                if(v!='.'){
                    if(col[v-'0']==1) return false;
                    col[v-'0']=1;
                }
                //3*3 blocks
                int rowIndex = 3*(i%3); //after every 3 rows, the rowIndex turns back to 0-3
                //in addition, 0-2, 3-5,6-8, there are 3 cases, colIndex is similar
                int colIndex = 3*(i/3);
                v=board[rowIndex+j/3][colIndex+j%3];
                if(v!='.'){
                    if(block[v-'0']==1) return false;
                    block[v-'0']=1;
                }
            }
        }
        return true;

    }
}
