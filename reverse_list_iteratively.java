/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = head;
        
        while(head.next != null) {
            
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = newHead;
            newHead = temp;
            
        }
        
        return newHead;
        
    }
}
