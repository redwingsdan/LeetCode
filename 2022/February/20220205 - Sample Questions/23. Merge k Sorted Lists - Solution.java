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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> values = new ArrayList<Integer>();
        for (ListNode list : lists) {
            while (list != null) {
                values.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(values);
        return populateValues(0, values);
    }
    
    private ListNode populateValues(int index, List<Integer> values) {
        if (index == values.size()) {
            return null;
        }
        ListNode populatedNode = populateValues(index+1, values);
        ListNode toReturn = new ListNode(values.get(index), populatedNode);
        return toReturn;
    }
}