public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
        result[0]=-1;
        result[1]=-1;
        int low=0,high=nums.length-1;
        //found the first number smaller than target, then number+1 is the start point
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                high=mid;
            }else if(nums[mid]<target){
                low=mid+1;
            }
        }
        if(low<0||low>=nums.length||nums[low]!=target){
            return result;
        }
        result[0]=low;
        low=0;
        high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2+1;
            if(nums[mid]>target){
                high=mid-1;
            }else{
                //nums[mid]<=target
                low=mid;
            }
        }
        result[1]=high;
        return result;
    }
}
