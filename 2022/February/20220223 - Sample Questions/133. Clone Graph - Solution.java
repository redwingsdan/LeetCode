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
        //Handle null graph
        if (node == null) {
            return node;
        }
        return createNode(node, new HashMap<>());
    }
    
    public Node createNode(Node node, Map<Integer, Node> foundNodes) {
        //If the current node value was already copied, then return the existing node
        if (foundNodes.containsKey(node.val)) {
            return foundNodes.get(node.val);
        }
        //Create the copy and add the clone to the found nodes map
        Node clone = new Node(node.val);
        if (foundNodes.get(node.val) == null) {
            foundNodes.put(node.val, clone);
        }
        //Iterate through each neighbor and add those nodes
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(createNode(neighbor, foundNodes));
        }
        return clone;
    }
}