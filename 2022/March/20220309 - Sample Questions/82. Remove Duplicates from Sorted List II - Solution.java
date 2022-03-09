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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prevNode = dummy;
        ListNode curNode = head;
        while (curNode != null) {
            if (curNode.next != null && curNode.next.val == curNode.val){
                while (curNode.next != null && curNode.next.val == curNode.val) {
                    curNode = curNode.next;
                }
                prevNode.next = curNode.next; 
            } else {
                prevNode = curNode;
            }
            curNode = curNode.next;
        }
        return dummy.next;
        
    }
}