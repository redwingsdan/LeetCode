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
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root, 0);
    }
    
    private int getMaxDepth(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        }
        int depthL = getMaxDepth(node.left, depth);
        int depthR = getMaxDepth(node.right, depth);
        return Math.max(depthL, depthR) + 1;
    }
}