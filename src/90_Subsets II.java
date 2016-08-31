public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //we divide the list into two parts
        //one half is the added last time, the other half is added before
        //if nums[i]==nums[i-1], we shall only combine it with the new half
        //if nums[i]!=nums[i], we shall combine it with all
        //Then the second thought is can we do better? Consider we can track the position that last time we begin adding
        //then we don't need the second List
        List<List<Integer>> result = new ArrayList<>();
        //List<List<Integer>> cur = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        //result.add(new ArrayList<Integer>(nums[0]));
        //cur.add(new ArrayList<Integer>(nums[0]));
        Arrays.sort(nums);//necessary
        int begin=0;//parameter tracking the begining point
        for(int i=0;i<nums.length;i++){
            if(i==0||nums[i]!=nums[i-1]) begin=0;//if two digits are different, we need to copy all origin 
            int size = result.size();
            for(int j=begin;j<size;j++){
                List<Integer> cur = new ArrayList<Integer>(result.get(j));
                cur.add(nums[i]);
                result.add(cur);//since we don't have the second arraylist, we only append new one 
            }
            //then mark the begining point,previous last one is size-1, so the begining point is size
            begin = size;
        }
        return result;
        
    }
}
