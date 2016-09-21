public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //search in the first column to determine which row the target could be
        //then search in that row, found the target or return false.
        //both mehtod using Binary Search
        
        //first col
        //int row = matrix.length;
        int start = 0, end=matrix.length-1;
        while(start<end-1){
            int mid=start+(end-start)/2;
            if(matrix[mid][0]>target){
                end=mid-1;
            }else if(matrix[mid][0]<target){
                start=mid;
            }else{
                //equal
                return true;
            }
        }
        int row = start==end?start:(target>=matrix[end][0]?end:start);
        //then search row
        start=0;
        end=matrix[0].length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(matrix[row][mid]>target){
                end=mid-1;
            }else if(matrix[row][mid]<target){
                start=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
}
