/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serializeString = new StringBuilder();
        generateString(root, serializeString);
        System.out.println(serializeString);
        return serializeString.toString();
        // a: 97
        // 1: b
        // 2: c
        // 3: d
        // null: a
        // null: a
        // 4: e
        // 5: f
 //       int node= root.val+97;
   //     char convertNode = (char)node;
     //   return serializeString;
        // change: instead of using alpha char, we use root value/
        // improvement from the original idea: using splitter to split every number and "a" to put in the queue as an array, then we can easily get each node and build from it
    }
    public void generateString (TreeNode node, StringBuilder str){
        if(node == null){
            str.append('a').append(',');
        }else{
            str.append(node.val).append(',');
            generateString(node.left,str);
            generateString(node.right,str);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // bcdef
        // bcaadeaafaa
        // b-97, 98-97 =1
        // c-97, 99-97 = 2
        // a-97, 97-97 = 0 => null;
        // a-97, 97-97 = 0 => null;
        // d-97, 100-97=3
        // e-97, 103-97 = 4
        // a-97, 97-97 = 0 => null;
        // a-97, 97-97 = 0 => null;
        // f-97, 104-97 = 5
        // a-97, 97-97 = 0 => null;
        // a-97, 97-97 = 0 => null;
        Queue<String> queue = new LinkedList<>();
        // using Queue to get the String, split the "," out.
        // asList because it allows our queue to contains null value
        queue.addAll(Arrays.asList(data.split(",")));
        System.out.println(queue);
        //recursive 
        return buildTreeFromString(queue);
        
    }
    
    public TreeNode buildTreeFromString(Queue<String> nodes){
        // get the first string in the queue and remove it.
        String val = nodes.remove();
        if(val.equals("a")){
            // if that node is null => return null
            return null;
        }
        else{
            // get the current node
            // example: "1" => 1
            TreeNode root = new TreeNode(Integer.valueOf(val));
            
            // left of the "1" => build from "2,a,a,3,4..."
            root.left = buildTreeFromString(nodes);
           // same method 
            root.right = buildTreeFromString(nodes);
            return root;
        }
        
        
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));