//depend on inorder traversal and preorder traversal, root is the preorder[0],as there are no duplicates,we can locate the 
//root index in inorder array. Then we know how many nodes are in the left and right subtree
//Recursively doing this, then we can build the Tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return builtTree(preorder,inorder,0,0,inorder.length-1);
    }
    public TreeNode builtTree(int[] preorder,int[] inorder, int prestart,int instart,int inend){
        if(instart>inend||prestart>preorder.length-1) return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int inIndex=0;//as we know there is no duplicate,we can iterate the inorder array, and find the root, and after
        //the root is the right subtree
        for(int i=instart;i<=inend;i++){
            if(inorder[i]==preorder[prestart]){
                inIndex=i;
                break;
            }
        }
        //as we know the inIndex
        //left tree node number:inIndex-instart,right tree node number:inend-instart
        root.left = builtTree(preorder,inorder,prestart+1,instart,inIndex-1);
        root.right = builtTree(preorder,inorder,prestart+1+inIndex-instart,inIndex+1,inend);
        return root;
    }
}
