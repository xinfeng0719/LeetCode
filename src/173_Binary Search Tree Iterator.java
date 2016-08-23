//maintain a Stack, and we only store the left side TreeNode in the tree, every time we pop the smallest number, we will look at its right side
//and push the left side in this node's right side. 
//Or we could say "inorder" iterative method(^ _ ^), then will be easier for understanding
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> s = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        while(root!=null){
            s.push(root);
            root = root.left;
        }    
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur=s.pop();
        int temp=cur.val;
        TreeNode t = cur.right;
        while(t!=null){
            s.push(t);
            t = t.left;
        }
        return temp;
    }
    public void helper(TreeNode r){
        while(r!=null){
            s.push(r);
            r = r.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
