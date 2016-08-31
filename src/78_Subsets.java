public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);//after sort, we can ignore the duplicate
        result.add(new ArrayList<Integer>());
        for(int i=0;i<nums.length;i++){
            //as we have 1 number, we add it to origin list, combine origin list and new list, we have new lists
            int num = nums[i];
            List<List<Integer>> newLists = new ArrayList<>();
            for(List<Integer> s:result){
                List<Integer> tmp = new ArrayList<Integer>(s);
                tmp.add(num);
                newLists.add(tmp);
            }
            result.addAll(newLists);
        }
        
        return result;
    }
}
