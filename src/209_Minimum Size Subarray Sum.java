public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //subarray
        //assume size K window exist
        int[] sums = new int[nums.length+1];
        for(int i=1;i<sums.length;i++){
            sums[i]=sums[i-1]+nums[i-1];
        }
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<sums.length;i++){
            int end=binarySearch(1,sums.length-1,sums[i]+s,sums);
            if(end==sums.length) break;
            if(end-i<minLen) minLen=end-i;
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
    private int binarySearch(int lo,int hi,int key,int[] sums){
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(sums[mid]>=key){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
}
