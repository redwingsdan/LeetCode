/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //Return null for missing children
        if (root == null) {
            return root;
        }
        //If the left child is present then point to the right child
        if (root.left != null) {
            root.left.next = root.right;
        }
        //If there is a right child and the current node is pointing to a node (ie: not the root)
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        //DFS the nodes
        connect(root.left);
        connect(root.right);
        return root;
    }
}