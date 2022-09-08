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
        boolean foundP= false, foundQ= false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Pattern: When we found the p || q at a root => go to left and right to find the rest
                if(root == null) return null;

        if(root.val == q.val){
            foundQ = true;
            return root;
        }
        if(root== q|| root == p|| root == null){
            foundP = true;
            return root;
        }
        
       TreeNode left = lowestCommonAncestor(root.left,p,q);
        if(foundQ && foundP){
            return left;
        }
            TreeNode right = lowestCommonAncestor(root.right,p,q);
       if(left != null && right != null){
           return root;
       }
        if(left == null){
            return right;
        }else {
            return left;
        }
        
    }
}