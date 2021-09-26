/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    
    int index = 0;

    public String serialize(Node root) {
        if(root == null)
            return null;
        StringBuilder sb = new StringBuilder();
        
        sb.append((char)(root.val + '0'));
        
        
        
        for(Node node : root.children){
            sb.append(serialize(node));
        }
        
        sb.append('#');
        return sb.toString();
    }
    
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
       if(data == null)
           return null;
        if(data.length() == index)
            return null;
        
        Node node = new Node(data.charAt(index) - '0', new ArrayList<Node>());
        index++;
        while (data.charAt(index) != '#') {
            node.children.add(deserialize(data));
        }

        index++;
        
        return node;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));