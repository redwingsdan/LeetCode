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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		//Create the list of the first tree
        List<Integer> list1 = new ArrayList<Integer>();
        if (root1 != null) {
            list1.add(root1.val);
        }
        traverse(root1, list1);
		//Create the list of the second tree
        List<Integer> list2 = new ArrayList<Integer>();
        if (root2 != null) {
            list2.add(root2.val);
        }
        traverse(root2, list2);
		//Combine the lists and sort
        List<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < list1.size(); i++) {
            answer.add(list1.get(i));
        }
        for (int j = 0; j < list2.size(); j++) {
            answer.add(list2.get(j));
        }
        Collections.sort(answer);
        return answer;
    }
    
    private TreeNode traverse(TreeNode node, List<Integer> list) {
		//Return null for nodes with no child
        if (node == null) {
            return null;
        }
		//Left traverse and add non-null values
        TreeNode left = traverse(node.left, list);
        if (left != null) {
            list.add(left.val);
        }
		//Right traverse and add non-null values
        TreeNode right = traverse(node.right, list);
        if (right != null) {
            list.add(right.val);
        }
        return node;
    }
}