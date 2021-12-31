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
    public int maxAncestorDiff(TreeNode root) {
        //Return 0 if no nodes
        if (root == null) {
            return 0;
        }
        return findMaxAncestor(root, root.val, root.val);
    }
    
    public int findMaxAncestor(TreeNode root, int previousMax, int previousMin) {
        //If there are no more children on this path determine the value for that branch
        if (root == null) {
            return previousMax - previousMin;
        }
        //Determine the current max and min values based on the current branch
        previousMax = Math.max(previousMax, root.val);
        previousMin = Math.min(previousMin, root.val);
        //DFS the nodes
        int left = findMaxAncestor(root.left, previousMax, previousMin);
        int right = findMaxAncestor(root.right, previousMax, previousMin);
        //Find the max diff between the two branches
        return Math.max(left, right);
    }
}