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
    public int countNodes(TreeNode root) {
        //if root.right's height=h-1, it means left subtree is complete
        if(root==null) return 0;
        int height = getHeight(root);
        if(height==1) return 1;
        int hRight = getHeight(root.right);
        if(hRight==height-1){
            //if root.right's height=h-1, it means left subtree is complete filled with height (h-1)
            return (1<<height-1)+countNodes(root.right);
        }else{
            //leftsubtree is a complete tree that needs to be calculated, but right tree is complete filled with height(h-2)
            return (1<<height-2)+countNodes(root.left);
        }
    }
    public int getHeight(TreeNode root){
        int height=0;
        while(root!=null){
            height++;
            root = root.left;
        }
        return height;
    }
}
