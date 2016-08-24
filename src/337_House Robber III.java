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
    public int rob(TreeNode root) {
     //there will be 2 cases when we go from bottom up, that is we can rob root or we can't rob root   
     //in order to maintain previous rob result, we introduce int[2] as parameter
     int[] res = rob2(root);
     return Math.max(res[0],res[1]);
    }
    public int[] rob2(TreeNode root){
        int[] res = new int[2];
        if(root==null){
            return res;
        }
        int[] left = rob2(root.left);
        int[] right = rob2(root.right);
        //as says before, case 0 means we choose the root, case 1 means we don't choose the root
        res[0]= root.val+left[1]+right[1];
        res[1]= Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return res;
    }
}
