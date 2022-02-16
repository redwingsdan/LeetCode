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
    public ListNode swapPairs(ListNode head) {
        //Empty list
        if (head == null) {
            return head;
        }
        //pointer to iterate through
        //if there are multiple items, then set the pointer to the next value
        ListNode pointer = head;
        if (head != null && head.next != null) { 
            pointer = head.next;
        }
        ListNode futurePointer = null;
        //While there are 2 values left to be swapped
        while (head != null && head.next != null) {
            //pointer's next value
            ListNode temp = head.next.next;
            head.next.next = head;
            head.next = temp;
            futurePointer = head;
            head = head.next;
            //If there are more values, then update the future pointer
            if (head != null && head.next != null) { 
                futurePointer.next = head.next;
            }
        }
        return pointer;
    }
}