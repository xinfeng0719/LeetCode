/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //iterative
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummyhead=new ListNode(0);
        ListNode temp=head;
        while(temp!=null){
            ListNode next=temp.next;
            ListNode prev=dummyhead.next;
            dummyhead.next=temp;
            temp.next=prev;
            temp=next;
        }
        return dummyhead.next;
    }
}
//recursive
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode rest=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return rest;
    }
}
