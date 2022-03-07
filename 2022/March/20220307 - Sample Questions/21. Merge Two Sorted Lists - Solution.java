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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode list = ans;
        //Iterate through both lists, adding the lowest value to this list
        while (list1 != null && list2 != null) {
            int l1Val = list1 == null ? Integer.MAX_VALUE : list1.val;
            int l2Val = list2 == null ? Integer.MAX_VALUE : list2.val;
            if (l1Val > l2Val) {
                list.next = list2;
                list2 = list2.next;
            } else {
                list.next = list1;
                list1 = list1.next;
            }
            list = list.next;
        }
        //Append the remaining list to the end
        if (list1 != null) {
			list.next = list1;
		} else {
			list.next = list2;
		}
        
        return ans.next;
    }
}