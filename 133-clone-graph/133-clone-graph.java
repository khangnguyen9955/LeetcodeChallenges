/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // create a hashmap to store all the pairs, avoid duplicate neighbor pair
      HashMap<Integer,Node> map = new HashMap<>();
     return helper(node,map);
    }
    
   public Node helper(Node node, HashMap<Integer,Node> map){
       
       if(node == null) return null;
       // contains => return that pair
       if(map.containsKey(node.val))
       {
           return map.get(node.val);
       }
       else{
           // clone here
           // create new graph with the node.val (1) 
           Node newGraph= new Node(node.val);
           // put it into the hashmap
           map.put(node.val,newGraph);
           // for each neighbor in the node
           for(Node neighbor : node.neighbors){
               // add its neighbor pair into this graph
               newGraph.neighbors.add(helper(neighbor,map));
           }
        return newGraph;    
       }
   }
}