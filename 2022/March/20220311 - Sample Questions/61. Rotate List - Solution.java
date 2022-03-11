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
    public ListNode rotateRight(ListNode head, int k) {
        //Nothing to shift
        if (head == null || k==0) {
            return head;
        }
        //Find the tail and the length of the list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        
        //Point the current tail to the head to create a cycle
        tail.next = head;
        //Determine the index that rotation will stop at (in case k > length)
        int rotationPoint = length - k % length;
        tail = head;
        //Move the tail pointer to the head again and move to the stop node
        while (rotationPoint-- > 1) {
            tail = tail.next;  
        }
        //Update the new tail to be the stop node
        head = tail.next;
        tail.next = null;

        return head;  
    }
}