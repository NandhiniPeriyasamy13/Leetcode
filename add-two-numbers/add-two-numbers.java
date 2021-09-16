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
        //base case
        int sum = (l1.val + l2.val);
        int carry = sum / 10;
        
        ListNode head = new ListNode(sum %10);
        
        ListNode cur = head;
        
        l1 = l1.next;
        l2 = l2.next;
        
        while(l1 != null && l2 != null){
             sum = l1.val + l2.val + carry;
            carry = sum /10;
            ListNode node = new ListNode(sum%10);
         cur.next = node;
         cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            sum = l1.val + carry;
            carry = sum /10;
            ListNode node = new ListNode(sum%10);
         cur.next = node;
         cur = cur.next;
            l1 = l1.next;
        }
        
        while(l2 != null){
            sum = l2.val + carry;
            carry = sum /10;
            ListNode node = new ListNode(sum%10);
         cur.next = node;
         cur = cur.next;
            l2 = l2.next;
        }
        
        carry = sum /10;
        if(carry > 0){
            cur.next = new ListNode(carry); 
        }
        
        return head;
        
    }
    
    
}