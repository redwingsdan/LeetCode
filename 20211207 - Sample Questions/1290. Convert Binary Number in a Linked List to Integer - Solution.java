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
    public int getDecimalValue(ListNode head) {
        int value = 0;
        int index = 0;
        ListNode node = head;
        while (node.next != null) {
            index++;
            node = node.next;
        }
        while (index >= 0) {
            value += (head.val * Math.pow(2, index));
            index--;
            head = head.next;
        }
        return value;
    }
}