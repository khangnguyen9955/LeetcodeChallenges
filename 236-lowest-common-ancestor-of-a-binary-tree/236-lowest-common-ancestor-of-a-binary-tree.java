class Solution {
        boolean foundP= false, foundQ= false;
// improve: a flag to check that we found p or q, doesnt need to check all the tree anymore
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
        // if we found p and q at left subtree, just return it !! 
        if(foundQ && foundP){
            return left;
        }
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //if we have not found p and q at left subtree, it must be in right or root.
        
       if(left != null && right != null){ 
           // if left and right is not null, it must be the root
           return root;
       }
        // but if the left or the right is null, it must be the rest.
        if(left == null){
            return right;
        }else {
            return left;
        }
        
    }
}