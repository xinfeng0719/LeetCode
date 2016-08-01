public class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length-1;
        for(int i=last-1;i>=0;i--){
            if(nums[i]>=last-i){
                last=i;
            }
        }
        return last==0;
    }
}
