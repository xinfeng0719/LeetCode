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
    int prev;
    boolean first=true;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        boolean left = isValidBST(root.left);
        if(first){
            prev=root.val;
            first=false;
        }else{
            if(root.val<=prev) return false;
            prev=root.val;
        }
        boolean right=isValidBST(root.right);
        return left&&right;
    }
}
