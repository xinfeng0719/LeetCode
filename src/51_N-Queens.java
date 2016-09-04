public class Solution {
    public List<List<String>> solveNQueens(int n) {
        //from 2D to 1D，we will need a function that translate int[] pos into List<List<String>>
        int[] col = new int[n];//col[0] means row=0, Queen is at column :col[0],similarly, col[n] means in row N, queen in column col[n];
        List<List<String>> result = new ArrayList<>();
        placeQueens(result,col,n,0);
        return result;
    }
    private void placeQueens(List<List<String>> result, int[] col,int n,int curRow){
        if(curRow==n){
            result.add(build(col));
        }
        for(int j=0;j<n;j++){
            if(checkValid(col,j,curRow)){
                col[curRow]=j;
                placeQueens(result,col,n,curRow+1);
            }
        }
    }
    private boolean checkValid(int[] col,int curCol,int curRow){
        for(int row=0;row<curRow;row++){
            //only care the row before since we don't put any number after curRow
            int val = col[row];
            if(curCol==val) return false;//same column
            int colDif = Math.abs(curCol-val);
            int rowDif = curRow-row;
            if(colDif==rowDif) return false;//diagnose
        }
        return true;
        
    }
    private List<String> build(int[] col){
        List<String> result = new ArrayList<>();
        for(int row = 0;row<col.length;row++){
            int column = col[row];
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<col.length;i++){
                if(i==column){
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
    

}
