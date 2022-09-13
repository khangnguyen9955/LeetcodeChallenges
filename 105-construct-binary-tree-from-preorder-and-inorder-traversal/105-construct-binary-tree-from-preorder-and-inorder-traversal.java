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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return result(0,0,preorder.length-1,preorder,inorder);
    }
    
    public TreeNode result(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart > preorder.length-1 || inStart > inEnd){
            return null;
        }
     
        // preorder [root,left,right];
        // => get the root first, then build the tree
        TreeNode root = new TreeNode(preorder[preStart]); 
        int inIndex =0; // store the index when we found the root in inorder 
        for(int i= inStart; i<=inEnd;i++){
            if(root.val == inorder[i]){ // found root in inorder
                inIndex = i; // store it
            }
        }
        // when we found the root, so we knew that the left subtree will be from the start to the index-1, so we just go from instart -> inindex-1; besides, we find the next elem in the prestart so increase it 
        root.left = result(preStart+1,inStart,inIndex-1, preorder,inorder); 
        // the right subtree will be from the index-1 -> inEnd, because as we knew the left is on the first half of INORDER. And we will find the first right element, so we need to get the index of current node + the length of left tree (inIndex-inStart) and then + 1 (root).
        // and we will start from the inIndex+1 (the first elem right after the left tree) to the last.
        root.right = result(preStart + inIndex - inStart + 1, inIndex+1, inEnd, preorder,inorder);
        return root;
    }
}