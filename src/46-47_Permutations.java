//I distinct number
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean visit[] = new boolean[nums.length];
        List<Integer> temp = new ArrayList<Integer>();
        dfs(nums,visit,result,temp,0);
        return result;
    }
    public void dfs(int[] nums,boolean[] visit,List<List<Integer>> result, List<Integer> temp,int step){
        if(step==nums.length){
            result.add(new ArrayList<Integer>(temp));
        }else{
            for(int i=0;i<nums.length;i++){
                if(visit[i]==true){
                    continue;//find the first number that was not used
                }else{
                    //add number to the List
                    visit[i]=true;
                    temp.add(nums[i]);
                    dfs(nums,visit,result,temp,step+1);
                    temp.remove(step);
                    visit[i]=false;
                }
            }
        }
        
        return;
    }
}
//II, contains duplicate, but generate unique permutations
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean visit[] = new boolean[nums.length];
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums,visit,result,temp,0);
        return result;
    }
    public void dfs(int[] nums,boolean[] visit,List<List<Integer>> result, List<Integer> temp,int step){
        if(step==nums.length){
            result.add(new ArrayList<Integer>(temp));
        }else{
            for(int i=0;i<nums.length;i++){
                if(visit[i]==true||(i>0&&nums[i]==nums[i-1]&&visit[i-1]==false)){
                    //duplicate happens when we use value nums[i] as head in the second time
                    continue;//find the first number that was not used
                }else{
                    //add number to the List
                    visit[i]=true;
                    temp.add(nums[i]);
                    dfs(nums,visit,result,temp,step+1);
                    temp.remove(step);
                    visit[i]=false;
                }
            }
        }
        
        return;
    }
}
