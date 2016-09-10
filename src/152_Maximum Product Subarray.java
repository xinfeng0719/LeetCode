public class Solution {
    public int maxProduct(int[] nums) {
        int[] dp = new int[2];//dp[0] shows maximum in positive, dp[1] shows maximum in negative
        dp[0]=1;dp[1]=1;
        int max = nums[0];
        //boolean isPos = nums[0]>0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                dp[0]*=nums[i];
                dp[1]=dp[1]<0?dp[1]*nums[i]:1;//if we don't have any negative number yet, the dp[1] shall still be 1
                max = Math.max(max,dp[0]);
            }else if(nums[i]<0){
                //boolean isPos = dp[1]>0; since we need dp[1] as temp, get rid of boolean
                int temp=dp[1];
                dp[1]=dp[0]*nums[i];
                if(temp>0){
                    //when dp[1] = 1
                    dp[0]=1;
                }else{
                    //when dp[1] <0
                    dp[0]=temp*nums[i];
                    max = Math.max(max,dp[0]);
                }
                
            }else{
                //nums[i]==0
                //any result before shall be reset
                dp[0]=1;
                dp[1]=1;
                max = Math.max(max,0);
            }
        }
        return max;
    }
}
