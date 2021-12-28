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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sol = getSumFromLists(null, new ListNode(), l1, l2, 0);
        return sol;
    }
   
    private ListNode getSumFromLists(ListNode sol, ListNode nextNode, ListNode l1, ListNode l2, Integer carryover) {
        int val = 0;
        ListNode l1next = null;
        ListNode l2next = null;
        if (l1 != null) {
            val += l1.val;
            l1next = l1.next;
        }
        if (l2 != null) {
            val += l2.val;
            l2next = l2.next;
        }
        nextNode.val = (val + carryover) % 10;
        carryover = (int) (val + carryover)/10;
        if (sol == null) {
            sol = nextNode;
            sol.next = nextNode.next;
        }
        if (l1next == null && l2next == null) {
            if (carryover != 0) {
                nextNode.next = new ListNode(carryover);
            }
            return sol;
        }
        nextNode.next = new ListNode();
        return getSumFromLists(sol, nextNode.next, l1next, l2next, carryover);
    }
    
    
    //SOLUTION DOESNT WORK DUE TO int limits
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Integer sum = getSumFromList2(0, 0, l1) + getSumFromList2(0, 0, l2);
        
        ListNode sol = createListFromNumber2(sum, new ListNode());
        return sol;
    }
    
    private ListNode createListFromNumber2(Integer number, ListNode list) {
        int val = (int) number % 10;
        list.val = val;
        number = (int) number/10;
        if (number != 0) {
           list.next = new ListNode();
           createListFromNumber2(number, list.next);
        }
        return list;
    }
    
    private Integer getSumFromList2(Integer sum, Integer tensPlace, ListNode l) {
        sum += (int)Math.pow(10, tensPlace) * l.val;
        tensPlace++;
        if (l.next != null) {
            return getSumFromList2(sum, tensPlace, l.next);
        }
        return sum;
    }
}