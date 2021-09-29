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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        int mcount = 1;
        int ncount = 0;
        
        ListNode cur = head;
        ListNode mnode;
        
        while(cur != null){
            while(cur != null && mcount<m){
                mcount++;
                cur = cur.next;
            }
            
            mnode = cur;
            
            while(cur != null && ncount <= n){
                ncount++;
                cur = cur.next;
            }
            
            if(mnode != null){
                mnode.next = cur;
                mcount = 1;
                ncount = 0;
            }
        }
        
        return head;
    }
}