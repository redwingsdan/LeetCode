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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddList = head;
        ListNode evenList = head.next;
        ListNode firstEven = head.next;
        ListNode currentNode = head.next.next;
        int index = 1;
        while (currentNode != null) {
            if (index % 2 == 0) {
                evenList.next = currentNode;
                evenList = currentNode;
            } else {
                oddList.next = currentNode;
                oddList = currentNode;
            }
            currentNode = currentNode.next;
            index++;
        }
        oddList.next = firstEven;
        evenList.next = null;
        return head;
    }
}