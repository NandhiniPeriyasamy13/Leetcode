/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "#,";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val+",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = Arrays.asList(data.split(","));
        
        int size = list.size();
        return deserializeHelper(list, size);
    }
    
    private TreeNode deserializeHelper(List<String> list, int n){
        if(index == n)
            return null;
        
        if(list.get(index).equals("#"))
            return null;
        
        TreeNode node = new TreeNode(Integer.valueOf(list.get(index)));
        index++;
        node.left = deserializeHelper(list, n);
        index++;
        node.right = deserializeHelper(list, n);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));