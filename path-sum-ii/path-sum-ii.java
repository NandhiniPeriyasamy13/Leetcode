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
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum(root, targetSum, new ArrayList<>(), 0);
        return ans;
    }
    
    private void pathSum(TreeNode root, int target, List<Integer> path, int sum){
        if(root == null)
            return;
       if(root.left == null && root.right == null){
            if(target == sum+root.val){
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        
        path.add(root.val);
        sum += root.val;
        pathSum(root.left, target, path, sum);
       // path.remove(path.size()-1);
        pathSum(root.right, target, path, sum);
        path.remove(path.size()-1);
    }
}