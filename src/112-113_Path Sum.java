//Path Sum I determine if the sum exist
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null&&sum==0) return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}

//Path Sum II not only determine, but record every path with the target summation
//DFS becareful we need to backtrack the "cur" ArrayList
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(root==null) return result;
        DFS(root,sum,result,temp);
        return result;
        
    }
    public void DFS(TreeNode root,int left,ArrayList<List<Integer>> result,ArrayList<Integer> cur){
        cur.add(root.val);
        int remain=left-root.val;
        if(root.left==null&&root.right==null&&remain==0){
            result.add(new ArrayList(cur));
        }
        if(root.left!=null) DFS(root.left,remain,result,cur);
        if(root.right!=null) DFS(root.right,remain,result,cur);
        cur.remove(cur.size()-1); //back to higher level, remove the last number that we add to the cur arraylist
    }
}
