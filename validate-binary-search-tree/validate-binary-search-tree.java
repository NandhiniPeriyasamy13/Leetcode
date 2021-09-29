/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        if(root.left != null){
            int pred = getPredecessor(root.left);
            if(pred >= root.val)
                return false;
        }
           
        if(root.right != null){
            int succ = getSuccessor(root.right);
            if(succ <= root.val)
                return false;
        }
        
        
        return isValidBST(root.left) && isValidBST(root.right);
        
    }
    
    
    private int getPredecessor(TreeNode root){
        if(root.right == null)
            return root.val;
        
        if(root.right != null)
            return getPredecessor(root.right);
        
        if(root.left != null)
            return getPredecessor(root.left);
        
        return root.val;
    }
    
    
    private int getSuccessor(TreeNode root){
        if(root.left != null)
            return getSuccessor(root.left);
        
        if(root.right != null)
            return getPredecessor(root.right);
        
        return root.val;
    }
    
}