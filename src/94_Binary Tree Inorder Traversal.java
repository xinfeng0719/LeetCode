/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//recursive
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        recur(root,result);
        return result;
    }
    public void recur(TreeNode root,List<Integer> result){
        if(root.left!=null) recur(root.left,result);
        result.add(root.val);
        if(root.right!=null) recur(root.right,result);
    }
}
//interative
//the logic is we shall goes left, then if we reach the end, then we backtrack to its parent node, then add right node
//we maintain a temp node, temp goes its left track and then we push every temp node into stack. Only if temp equals null
//we pop the left-most node from stack, and add it to the ArrayList. Then we goes the right side of this node. Follow the same way
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Stack<TreeNode> record = new Stack<TreeNode>();
        TreeNode temp=root;
        while(!record.isEmpty()||temp!=null){
            if(temp!=null){
                //not goes to the left-most node
                record.push(temp);
                temp=temp.left;
            }else{
                //already reach the left-most, then figure the right node
                TreeNode t = record.pop();
                result.add(t.val);
                temp=t.right;
            }
        }
        return result;
    }
}


