/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for(int i=0;i<n;i++){
            p = p.next;
        }
        if(p!=null){
            while(p.next!=null){
                p = p.next;
                q = q.next;
            }
            q.next = q.next.next;
        }else{
            return head.next;
        }
        return head;
    }
}
