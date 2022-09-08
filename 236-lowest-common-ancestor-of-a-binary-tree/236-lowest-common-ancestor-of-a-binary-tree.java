/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Pattern: When we found the p || q at a root => go to left and right to find the rest
        if(root== q|| root == p|| root == null){
            return root;
        }
           TreeNode left = lowestCommonAncestor(root.left,p,q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }
        else{
            return root;
        }
    }
}