//similar to 105
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode buildTree(int[] inorder,int[] postorder,int instart,int inend,int poststart,int postend){
        //recursion stop condition
        //if(instart<inend||postend<0){
          //  return null;
        //}
        if(instart>inend||poststart>postend||postend<0||postend>postorder.length-1) return null;
        TreeNode root = new TreeNode(postorder[postend]);
        int inIndex=0;
        for(int i=instart;i<=inend;i++){
            if(inorder[i]==postorder[postend]){
                inIndex=i;
                break;
            }
        }
        root.left = buildTree(inorder,postorder,instart,inIndex-1,poststart,postend-1-(inend-inIndex));
        
        
        root.right = buildTree(inorder,postorder,inIndex+1,inend,postend-(inend-inIndex),postend-1);
        return root;
    }
}
