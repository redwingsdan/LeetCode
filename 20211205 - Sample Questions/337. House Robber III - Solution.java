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
    public int rob(TreeNode root) {
        int answer[] = findMaxFromNode(root);
        //compare and choose that max
        return Math.max(answer[0],answer[1]);
    }
    
    private int[] findMaxFromNode(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        //Left traverse, find max
        int left[] = findMaxFromNode(node.left);
        //Right traverse, find max
        int right[] = findMaxFromNode(node.right);
        int answer[] = new int[2];
        //Determine the left and the right nodes to use to get the max value
        answer[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //Use the current node and the two child nodes
        answer[1] = node.val + left[0] + right[0];
        
        return answer;
    }
}