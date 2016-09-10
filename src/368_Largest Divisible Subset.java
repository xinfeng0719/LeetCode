public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums==null||nums.length==0) return result;
        Arrays.sort(nums);
        int[] count = new int[nums.length];
        count[0]=1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    count[i]=Math.max(count[i],count[j]+1);
                }
            }
        }
        
        int max=0;
        int maxIndex=0;
        for(int i=1;i<nums.length;i++){
            if(count[i]>max){
                max = count[i];
                maxIndex = i;
            }
        }
        
        int temp = nums[maxIndex];
        for(int i=maxIndex;i>=0;i--){
            if(temp%nums[i]==0&&count[maxIndex]-count[i]<=1){
                result.add(nums[i]);
                temp = nums[i];
                maxIndex=i;
            }
        }
        return result;
    }
}
