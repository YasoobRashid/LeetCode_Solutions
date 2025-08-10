/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //Recursively
        // if(head==null || head.next ==null){
        //     return head;
        // }

        // ListNode newHead = reverseList(head.next);
        // head.next.next = head;
        // head.next = null; 
        // return newHead;

        //Iterative
        if(head==null||head.next ==null){
            return head;
        }

        ListNode prevNode = null;
        ListNode currNode = head;

        while(currNode!=null){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;

            //update 
            prevNode = currNode;
            currNode= nextNode;
        }

        return prevNode;

    }
}