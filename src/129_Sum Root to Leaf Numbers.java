//BFS shows more complexity,we will use DFS in this problem. The key is hwo to maintain the "current total" during dfs
//1.we can create an array, then pass this array during DFS
//2.we can create an global, then update this value during DFS
//3.We can recursively run the calculation, then return the sum
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
    int total=0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        dfs(root,0);
        return total;
    }
    public void dfs(TreeNode root,int before){
        int remain=before*10+root.val;
        if(root.left==null&&root.right==null){
            total+=remain;
            return;
        }
        if(root.left!=null) dfs(root.left,remain);
        if(root.right!=null) dfs(root.right,remain);
    }
}

//then recursive method
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null){
            return root.val;
        }
        if(root.left!=null){
            root.left.val=root.val*10+root.left.val;
        }
        if(root.right!=null){
            root.right.val=root.val*10+root.right.val;
        }
        return sumNumbers(root.left)+sumNumbers(root.right);
    }
}
