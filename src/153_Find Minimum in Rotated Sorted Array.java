public class Solution {
    public int findMin(int[] nums) {
        //corner case
        if(nums[0]<nums[nums.length-1]) return nums[0];
        //general
        int start=0, end=nums.length-1;
        while(start<end-1){
            int mid = start+(end-start)/2;
            if(nums[mid]>nums[end]&&nums[mid]>nums[start]){
                start=mid+1;
            }else if(nums[mid]<nums[end]&&nums[mid]<nums[end]){
                end=mid;
            }
        }
        return nums[end]>nums[start]?nums[start]:nums[end];
    }
}
