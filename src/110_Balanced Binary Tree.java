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
    public boolean isBalanced(TreeNode root) {
        if(checkHeight(root)==-1) return false;
        return true;
    }
    public int checkHeight(TreeNode root){
        if(root==null) return 0;
        int left = checkHeight(root.left);
        if(left==-1) return -1;
        int right = checkHeight(root.right);
        if(right==-1) return -1;
        int diff = Math.abs(left-right);
        if(diff>1){
            return -1;
        }else{
            return Math.max(left,right)+1;
        }
    }
}
