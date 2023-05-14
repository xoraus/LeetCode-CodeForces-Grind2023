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
    public ListNode deleteDuplicates(ListNode curr) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode tail = dummy;

        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                int temp = curr.val;
                while(curr != null && curr.val == temp){
                    curr = curr.next;
                }
            } 
            else {
                tail.next = curr;
                tail = curr;
                curr = curr.next;
            }
        }

        tail.next = null;
        return dummy.next;
    }
}