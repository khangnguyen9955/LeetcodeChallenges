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
      // create a hashmap to store all the pairs, avoid duplicate neighbor pair
        HashMap<Node,Node> map = new HashMap<>();
     public Node cloneGraph(Node node) {
        if(node ==null) return node;
          // contains => return that pair
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newGraph= new Node(node.val, new ArrayList());
           // clone here
           // create new graph with the node.val (1) 
        map.put(node,newGraph);
         // put it into the new graph
        for(Node neighbor: node.neighbors){
                // add its neighbor pair into this graph
            newGraph.neighbors.add(cloneGraph(neighbor));
        }
        return newGraph;
    }
    

}