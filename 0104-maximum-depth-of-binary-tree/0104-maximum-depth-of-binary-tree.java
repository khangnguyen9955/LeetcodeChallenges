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
    public int maxDepth(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        else {
                int lDepth = maxDepth(root.left);
                int rDepth = maxDepth(root.right);
        
            if (lDepth>rDepth){
                return lDepth+1;
            }
            else{
                return rDepth+1;
            }
        }
        
        
        
        
        
    }
}