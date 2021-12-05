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
        int l = lists.length;
        
        int interval = 1;

        while(interval < l) {
            int idx = 0;
            while(idx < l) {
                lists.set(idx, mergeTwoList(lists[idx], lists[idx+interval]));
                idx += interval;
            }
            interval *= 2;
        } 

        return l > 0 ? lists.get(0) : null;
    }
    
    private ListNode mergeTwoList(ListNode listA, ListNode listB){
        ListNode dummy = new ListNode(1);
        ListNode h = dummy;
        while(listA != null && listB != null) {
            if(listA.val > listB.val) {
                h.next = listB;
                h = h.next; 
                listB = listB.next;
            } else {
                h.next = listA;
                h = h.next; 
                listA = listA.next;
            }
        }
        h.next = listA == null ? listA : listB;
        return dummy.next;
    }
}
