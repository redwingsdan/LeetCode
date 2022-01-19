/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode target = head;
        ListNode fastTarget = head;
        while (fastTarget != null && fastTarget.next != null) {
            target = target.next;
            fastTarget = fastTarget.next.next;
            //If the pointers ever catch up then end
            if (target == fastTarget) {
                break;
            }
        }
        //If the target reached null then we have no cycle
        if (fastTarget == null || fastTarget.next == null) {
            return null;
        }
        //Update the head to point to the targeted match
        while (head != target) {
            head = head.next;
            target = target.next;
        }
        return head;
    }
}