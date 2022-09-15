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

// find the smallest kth node
// firstly, come up with these questions:
// 1) Do we need to find the smallest elem fisrt?
// -> Yes, obviously. Actually the requirement also commited that, because we find the kth smallest means we knew that elem is not the smallest, right?
// 1.1) So how we find it? 
// -> This is a BST. We can use Binary Search to find the smallest.
// 2) Now we got the smallest, how to find the kth smallest?
// -> We will flag the smallest in our tree, then find the next (kth-1) elem?
// -> If we do that way, I think there are a lot of unnecessary elements we need to find and flag before we got the Kth elem
// -> It is BST. Each level in the tree, we knew that there is at least 1 element less than 1 elem (root < right or left < root or both)
// -> So, with the last level of the tree, we got at least 1th smallest elem in the tree
// -> But with that way we need to find the last level.
// -> I think we can recursively, and use a count variable to count every level

class Solution {
    int count = 0;
    int result = Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return result;
    }
    
    public void helper(TreeNode root, int k){
        if (root == null){
            return;
        }
        helper(root.left,k);
        count++;
        if(count == k){result = root.val;}
        if(count < k){
        helper(root.right,k);
        }
    }
}