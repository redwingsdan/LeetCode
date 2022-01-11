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
    public ListNode middleNode(ListNode head) {
        ListNode node = head;
        ListNode mid = head;
        int i = 0;
		//Iterate through each node
        while (node != null) {
            i++;
			//Update the midpoint by 1 node every time there is an even count
            if (i % 2 == 0) {
                mid = mid.next;
            }
            node = node.next;
        }
        return mid;
    }
}