public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //column and row are both sorted
        //so the biggest value lay in the right corner
        //after compare, we can minimize the rectangle
        if(matrix==null||matrix.length<1||matrix[0].length<1) return false;
        return searchHelp(matrix,target,0,0,matrix.length-1,matrix[0].length-1);
        
    }
    public boolean searchHelp(int[][] matrix, int target, int x1, int y1, int x2, int y2){
        if(x1>x2||y1>y2)return false;
        int mx=(x1+x2)/2;
        int my=(y1+y2)/2;
        if(matrix[mx][my]==target)return true;
        else if(matrix[mx][my]>target)return searchHelp(matrix, target, x1,y1,mx-1,y2)||searchHelp(matrix,target,mx,y1,x2,my-1);
        else return searchHelp(matrix,target, mx+1,y1,x2,y2)||searchHelp(matrix,target,x1,my+1,mx,y2);
    }
}
