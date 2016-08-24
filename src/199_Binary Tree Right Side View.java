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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> record = new LinkedList<TreeNode>();
        if(root==null) return result;
        record.offer(root);
        while(!record.isEmpty()){
            int size = record.size();
            TreeNode rightmost = record.peek();
            result.add(rightmost.val);
            for(int i=0;i<size;i++){
                TreeNode temp = record.poll();
                if(temp.right!=null) record.offer(temp.right);
                if(temp.left!=null) record.offer(temp.left);
            }
        }
        return result;
    }
}
