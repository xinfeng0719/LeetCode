public class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSize=0;
        if(matrix==null||matrix.length<1) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int result[][] = new int[row+1][col+1];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1'){
                    int min = Math.min(result[i+1][j],result[i][j]);
                    min = Math.min(min,result[i][j+1]);
                    result[i+1][j+1]=min+1;
                    int size = result[i+1][j+1];
                    if(size>maxSize){
                        maxSize = size;
                    }
                }
            }
        }
        return (int) Math.pow(maxSize,2);        
    }
}
