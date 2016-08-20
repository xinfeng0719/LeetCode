/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root,result,0);
        return result;
    }
    //dfs, determine by depth, even->add, odd->add in the first position
    public void dfs(TreeNode root, List<List<Integer>> result, int depth){
        if(root==null) return;
        dfs(root.left,result,depth+1);
        while(result.size()<=depth){
            result.add(new ArrayList<Integer>());
        }
        if(depth%2==0){
            //even
            result.get(depth).add(root.val);
        }else{
            //odd
            result.get(depth).add(0,root.val);
        }
        dfs(root.right,result,depth+1);
        
    }
}
