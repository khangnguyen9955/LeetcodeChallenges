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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // Max(sumLeft, sumRight, sumLeft + sumRight+root)          
        maxChildren(root);
        return result;
        
       
    }
    
    public int maxChildren(TreeNode node){
        if(node == null){
            return 0;
        }
        int rightValue =Math.max(maxChildren(node.right),0);
        int leftValue =Math.max(maxChildren(node.left),0); 
        int rootValue=node.val;
       result =  Math.max(leftValue+rightValue+rootValue,result);
       return Math.max(leftValue,rightValue) + node.val;
        
    }
}