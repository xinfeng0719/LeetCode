//first case, not limited in using number in the collection of candidate
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,result,temp,target,0);
        return result;
    }
    public void dfs(int[] candidates,List<List<Integer>> result, List<Integer> temp,int remain,int start){
        if(remain==0){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>remain) return;
            temp.add(candidates[i]);
            int after=remain-candidates[i];
            dfs(candidates,result,temp,after,i);
            temp.remove(temp.size()-1);
        }
    }
}


//each number can only be used once
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        //boolean[] visited = new boolean[candidates.length]; similar to Permutation, introduce a boolean
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(candidates,result,temp,target,0);
        return result;
    }
    public void dfs(int[] candidates,List<List<Integer>> result, List<Integer> temp,int remain,int position){
        if(remain==0){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=position;i<candidates.length;i++){
            if(candidates[i]>remain) return;
            if(i!=position&&candidates[i]==candidates[i-1]) continue;//similar to Permutation case
            temp.add(candidates[i]);
            int after = remain-candidates[i];
            dfs(candidates,result,temp,after,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
