/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //the key is to build a dummy header, and then create new node and append to the dummy head. use 'or' logic can make the code neat.
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //if(l1==null&&l2==null) return null; not needed.
        if(l2==null) return l1;
        if(l1==null) return l2;
        ListNode dummyhead = new ListNode(0);
        ListNode temp = dummyhead;
        int carry=0;
        int val;
        while(l1!=null||l2!=null){
            int add1=l1==null?0:l1.val;
            int add2=l2==null?0:l2.val;
            int sum=add1+add2+carry;
            temp.next = new ListNode(sum%10);
            carry=sum/10;
            temp = temp.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(carry==1){
            temp.next = new ListNode(1);
        }
        return dummyhead.next;
    }
}
