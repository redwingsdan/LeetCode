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
    int totalDiff = 0;
    public int findTilt(TreeNode root) {
        getDiffForNode(root);
        return totalDiff;
    }
    
    private int getDiffForNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //Left child val
        int leftDiff = getDiffForNode(node.left);
        //Right child val
        int rightDiff = getDiffForNode(node.right);
        totalDiff += Math.abs(leftDiff - rightDiff);
        //Need a way to continually sum the diffs with the current node
        return node.val + leftDiff + rightDiff;
    }
}
