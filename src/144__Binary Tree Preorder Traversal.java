//recursive method(straight forward)
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        recur(root,result);
        return result;
    }
    public void recur(TreeNode root,List<Integer> result){
        result.add(root.val);
        if(root.left!=null) recur(root.left,result);
        if(root.right!=null) recur(root.right,result);
    }
}

//iterative method
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        //use a stack
        Stack<TreeNode> record = new Stack<TreeNode>();
        record.push(root);
        while(!record.isEmpty()){
            TreeNode next = record.pop();
            result.add(next.val);
            if(next.right!=null) record.push(next.right);
            if(next.left!=null) record.push(next.left);
        }
        return result;
    }
}
