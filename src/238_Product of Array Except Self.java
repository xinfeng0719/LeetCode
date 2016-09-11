public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null) return null;
        int[] result = new int[nums.length];
        if(nums.length==0) return result;
        //normal
        result[nums.length-1]=1;
        int prev = nums[0];
        for(int i=nums.length-2;i>=0;i--){
            result[i]+=result[i+1]*nums[i+1];
        }
        for(int i=1;i<nums.length;i++){
            result[i]*=prev;
            prev*=nums[i];
        }
        return result;
    }
}
