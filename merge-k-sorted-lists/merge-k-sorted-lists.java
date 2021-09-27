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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        int n = lists.length;
        for(int i=0;i<n;i++){
            ListNode node = lists[i];
            if(node != null){
                pq.add(node);
            }
        }
        
        ListNode head = new ListNode();
        ListNode cur = head;
        
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            cur.next = new ListNode(node.val);
            cur = cur.next;
            if(node.next != null){
                pq.add(node.next);
            }
        }
        return head.next;
    }
}