/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode p = head;
        while(p.next!=null){
            ListNode next = p.next;
            if(next.val==p.val){
                p.next = next.next;
            }else{
                p = next;
            }
        }
        return head;
    }
}
