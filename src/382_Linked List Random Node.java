/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode first;
    Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        first = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int count=0;
        int result = -1;
        ListNode dummyhead = first;
        while(dummyhead!=null){
            //exact the same as in card shffule method
            if(random.nextInt(++count)==0){
                result = dummyhead.val;
            }
            dummyhead = dummyhead.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
