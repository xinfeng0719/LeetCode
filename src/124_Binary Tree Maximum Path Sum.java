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
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        int[] res = new int[1];
        res[0]=root.val;
        maxSum(root,res);
        return res[0];
    }
    public int maxSum(TreeNode root,int[] res){
        if(root==null) return 0;
        int leftMost=maxSum(root.left,res);
        int rightMost=maxSum(root.right,res);
        //3 cases, 1 only root,2 root and one side tree, 3 root and both side tree(special case, only happen in calMAX)
        //in recursion, we only need to care about the case 1 and case 2
        //but for subtree, what we shall return is the case when we include the root value
        int maxSub = root.val+Math.max(leftMost,rightMost);
        maxSub = Math.max(root.val,maxSub);
        int pathMax = Math.max(maxSub,root.val+leftMost+rightMost);
        res[0]=Math.max(pathMax,res[0]);
        return maxSub;
    }
}
