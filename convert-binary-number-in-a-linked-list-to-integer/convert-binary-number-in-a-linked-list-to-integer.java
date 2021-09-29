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
    public int getDecimalValue(ListNode head) {
        int count = -1;
        ListNode cur = head;
        
        while(cur != null){
            count++;
            cur = cur.next;
        }
        
        cur = head;
        int ans = 0;
        
        while(cur != null){
            ans += cur.val*Math.pow(2,count--);
            cur = cur.next;
        }
        
        return ans;
        
    }
}