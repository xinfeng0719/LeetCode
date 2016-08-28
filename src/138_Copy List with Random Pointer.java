/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        //copy list by add the same node after orginial
        //a->b->c  ->a-a'-b-b'-c-c'
        //then process random a'.random = a.random.next
        //3rd step divide the node
        if(head==null) return null;
        //copy
        RandomListNode temp = head;
        while(temp!=null){
            RandomListNode copy = new RandomListNode(temp.label);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }
        //process random pointer
        temp = head;
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random = temp.random.next;
            }else{
                temp.next.random=null;
            }
            temp = temp.next.next;
        }
        //divide
        temp = head;
        RandomListNode copyHead = temp.next;
        while(temp!=null){
            RandomListNode curNext = temp.next;
            if(curNext==null){
                //reach the end
                temp.next=null;
                break;
            }
            temp.next=curNext.next;
            temp = curNext;
        }
        return copyHead;
    }
}
