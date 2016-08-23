//the easiest way is doing a inorder traversal, and count the number, break at kth number
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> record = new Stack<TreeNode>();
        while(root!=null){
            record.push(root);
            root = root.left;
        }
        int index=0;
        while(!record.isEmpty()){
            TreeNode cur = record.pop();
            index++;
            if(index==k){
                return cur.val;
            }
            TreeNode temp = cur.right;
            while(temp!=null){
                record.push(temp);
                temp = temp.left;
            }
        }
        return 0;//some number shows not found
    }
}
//or we can use binary search, if kth number lies in the left, then we goes left, otherwise, goes right side.
//until the kth number in the root, and we return the root.condition is "k==count(root)"
//binary seacrh with the log(n). but actually, as we have the counting process, why don't we just count and say
//just for practising binary search writing
//ignore this code if you are smart engouth
/*public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count=countNodes(root.left);//number's count smaller than root's val
        if(k<=count){
            //kth number lies in the left side
            return kthSmallest(root.left,k);
        }else if(k>count+1){
            return kthSmallest(root.right,k-count-1);
        }
        return root.val;
    }
    public int countNodes(TreeNode root){
        if(root==null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
*/
