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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            TreeNode node = queue.peek();
            list.add(node.val);
            // each level of the tree, we will get the most right node 
            for(int i = 0 ; i < level; i ++){
                TreeNode curNode = queue.poll();
                if(curNode.right != null){
                queue.add(curNode.right);
                }
                if(curNode.left != null){
                queue.add(curNode.left);
                }
 //               list.add(queue.poll());
            }
        }
        
        return list;
    }
}