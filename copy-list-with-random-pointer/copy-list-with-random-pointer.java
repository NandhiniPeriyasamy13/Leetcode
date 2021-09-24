/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        
        HashMap<Node, Node> hm = new HashMap<>();
        
        while(cur != null){
            Node node = new Node(cur.val);
            hm.put(cur, node);
            cur = cur.next;
        }
        
        
        cur = head;
        while(cur != null){
            Node node = hm.get(cur);
            node.next = hm.get(cur.next);
            node.random = hm.get(cur.random);
            cur = cur.next;
        }
        
        
        return hm.get(head);
    }
}