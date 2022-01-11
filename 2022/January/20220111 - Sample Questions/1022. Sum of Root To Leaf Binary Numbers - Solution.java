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
    public int sumRootToLeaf(TreeNode root) {
        return traverse(root, "", 0);
    }
    
    private int traverse(TreeNode node, String binaryVal, int total) {
        //Append the binary value to the node
        binaryVal += node.val;
        //If both child nodes are null then add to the total
        if (node.left == null && node.right == null) {
            total += Integer.parseInt(binaryVal, 2);
            return total;
        }
        //Traverse the tree and sum the leaves if the child is not null
        if (node.left != null) {
            total = traverse(node.left, binaryVal, total);
        }
        if (node.right != null) {
            total = traverse(node.right, binaryVal, total);
        }
        return total;
    }
}