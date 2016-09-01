public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(n,k,1,result,temp);
        return result;
    }
    public void dfs(int n,int k,int cur,List<List<Integer>> result, List<Integer> temp){
        if(temp.size()==k){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=cur;i<=n;i++){
            temp.add(i);
            dfs(n,k,i+1,result,temp);
            temp.remove(temp.size()-1);
        }
    }
}
