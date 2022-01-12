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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertNode(root, val);
    }
    
    public TreeNode insertNode(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
            return node;
        }
        if (node.val > val) {
            TreeNode returned = insertNode(node.left, val);
            node.left = returned;
        } else {
            TreeNode returned = insertNode(node.right, val);
            node.right = returned;
        }
        return node;
    }
}