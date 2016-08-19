//start with the perfect binary tree,the root.left.next=root.right root.right.next=root.next.left(if root.next exist)
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        dfs(root);
    }
    public void dfs(TreeLinkNode root){
        if(root==null) return;
        if(root.left!=null){
            root.left.next=root.right;
        }
        dfs(root.left);
        if(root.right!=null&&root.next!=null){
            root.right.next = root.next.left;
        }
        dfs(root.right);
    }
}

//then think more complicated case, if the binary tree is not complete
//then our thought goes to iterate level by level, as we have at most N node, the time complexity goes to O(N), while the space complexity goes to O(1) sine we are using 3 node as parameter

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {//iterate all level, focusing on the first node
            
            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        //if cur.left is not the first node
                        prev.next = cur.left;
                    } else {
                        //if cur.left is the first node on this level
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }        
    }
}
