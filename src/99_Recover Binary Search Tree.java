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
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=null;
    //straight method is inorder traversal, with O(n) space, try using O(1) space
    public void recoverTree(TreeNode root) {
        dfs(root);
        if(first!=null&&second!=null){
            int temp=first.val;
            first.val=second.val;
            second.val=temp;
        }
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            dfs(root.left);
        }
        if(prev==null){
            prev=root;
        }else{
            //don't find first
            if(root.val<prev.val){
                if(first!=null){
                    second=root;
                    return;
                }else{
                    first=prev;
                    second=root;
                }
            }
            prev = root;
        }
        if(root.right!=null){
            dfs(root.right);
        }
    }
}
