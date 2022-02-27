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
    int width = 1;
    ArrayList<Integer> levelId = new ArrayList<>();
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxWidth(root, 1, 0);
        return width;
    }
    
    private void getMaxWidth(TreeNode node, int firstNodeVal, int level) {
        if (node == null) {
            return;
        }
        //If this is the first time we're at a new level, add the leftmost note
        //Otherwise determine if this new node increases the max width
        if (levelId.size() == level) {
            levelId.add(firstNodeVal);
        } else {
            width = Math.max(width, firstNodeVal - levelId.get(level) + 1);
        }
        //Move through the next items, incrementing the level each time as well as doubling the leftmost nodes
        getMaxWidth(node.left, firstNodeVal * 2, level + 1);
        getMaxWidth(node.right, firstNodeVal * 2 + 1, level + 1);
    }
}