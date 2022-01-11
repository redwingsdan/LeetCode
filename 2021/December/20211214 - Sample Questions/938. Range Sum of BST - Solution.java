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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return getSum(root, low, high);
    }
    
    private int getSum(TreeNode node, int low, int high) {
		//If the node is null then use 0 as the value
        if (node == null) {
            return 0;
        }
		//Create a new sum
        int sum = 0;
		//If the value of the node is within the range, add it to the sum
        sum += (node.val >= low && node.val <= high ? node.val : 0);
		//Get the sums of the left and right branches
        int leftSum = getSum(node.left, low, high);
        int rightSum = getSum(node.right, low, high);
        //Add the left and right branches if they are within the ranges (note the BST is sorted so left is always lower than root and right is always higher)
        sum += (node.val > low ? leftSum : 0);
        sum += (node.val < high ? rightSum : 0);
        return sum;
    }
}