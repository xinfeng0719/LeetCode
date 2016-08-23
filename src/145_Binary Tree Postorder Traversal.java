//recursive
//left and right child goes before its parent
//left->right->parent
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        recur(root,result);
        return result;
    }
    public void recur(TreeNode root,List<Integer> result){
        if(root.left!=null) recur(root.left,result);
        if(root.right!=null) recur(root.right,result);
        result.add(root.val);
    }
}
//interative
//interative is a little tricky
//we maintain two stack, for the second stack, we push the value from parent->right->left, then when we pop them it
//they'll follow left->right->parent order
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Stack<TreeNode> record = new Stack<TreeNode>();
        Stack<TreeNode> reverse = new Stack<TreeNode>();
        record.push(root);
        while(!record.isEmpty()){
            TreeNode cur=record.pop();
            reverse.push(cur);
            if(cur.left!=null) record.push(cur.left);//* shall be record, error if use reverse
            if(cur.right!=null) record.push(cur.right);
        }
        while(!reverse.isEmpty()){
            result.add(reverse.pop().val);
        }
        return result;
    }
}
