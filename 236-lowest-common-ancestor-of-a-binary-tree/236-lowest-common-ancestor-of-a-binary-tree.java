class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root == p || root == q) return root;
        
        TreeNode lca1 = lowestCommonAncestor(root.left, p, q);
        TreeNode lca2 = lowestCommonAncestor(root.right, p, q);
        
        if(lca1 != null && lca2 != null) return root;
        else if(lca1 != null) return lca1;
        else return lca2;
        
    }
}