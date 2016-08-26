//beat 28.58%, 1ms, however, get TLE sometime. Not pass the OA every time.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        //Since we need a height balanced BST, we still need the mid number in the ListNode
        //recursively, we build the BST using root.val=midpoint.val
        if(head==null) return null;
        ListNode pre = null;
        ListNode t1=head,t2=head;
        //find the mid point
        while(t2!=null&&t2.next!=null){
            pre = t1;//mark the point before mid point, end point for the left subtree
            t1 = t1.next;
            t2 = t2.next.next;
        }
        TreeNode root = new TreeNode(t1.val);
        if(pre!=null){//there is no condition we divide the list, however, if pre==null, we can't reach pre.next, so add this as condition
            pre.next = null;//divide the list into two by t1, one for left, one for right
            root.left = sortedListToBST(head);
        }
        root.right=sortedListToBST(t1.next);
        return root;
    }
}
