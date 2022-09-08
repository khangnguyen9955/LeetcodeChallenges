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
//root left right
// append that node to the List 
// append that list to the Linkedlist
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new LinkedList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) { // while queue exists elements, we still traverse
            int level = queue.size();
            List<Integer> currNodes = new ArrayList<>();
            for(int i =0 ; i < level; i++){
                TreeNode currNode = queue.poll(); // get the first element in queue and kick it out!
                currNodes.add(currNode.val); // add it to the sub array;
                // add left node and right node of the root to the queue
                if(currNode.left != null){
                       queue.add(currNode.left);
                }
                if(currNode.right !=null){
                        queue.add(currNode.right);                   
                }
            
            }
                list.add(currNodes);
        }
        
        return list;
    }
}