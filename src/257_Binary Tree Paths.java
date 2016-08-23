//straight forward, the only worth thinking point is how to maintain the string and different case while modifying the string
//as in java, each string point to a new position, there will be no need to think of backtracking
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root==null) return result;
        String cur="";
        dfs(root,result,cur);
        return result;
    }
    public void dfs(TreeNode root,List<String> record,String cur){
        if(cur==""){
            cur=cur+root.val;
        }else{
            cur=cur+"->"+root.val;
        }
        if(root.left==null&&root.right==null) record.add(cur);
        if(root.left!=null) dfs(root.left,record,cur);
        if(root.right!=null) dfs(root.right,record,cur);
    }
}
