public class Solution {
    public int rob(int[] nums) {
        //there will be 2 cases:
        //case 1: we don't rob the first, means we can rob the last one, from nums[1] to nums[last]
        //case 2: we rob the first, means we can't rob the last one,from nums[0] to nums[last-1]
        //then we can use House Robber I 's algorithm
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int num1=rob(nums,0,n-1);
        int num2=rob(nums,1,n);
        return Math.max(num1,num2);
        
    }
    public int rob(int[] nums, int start, int end){
        int pre = 0,cur=0;
        for(int i=start;i<end;i++){
            int next = Math.max(cur,pre+nums[i]);
            pre = cur;
            cur = next;
        }
        return cur;
    }
}
