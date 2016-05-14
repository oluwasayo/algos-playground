/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        return reverse(root);
    }

    private TreeNode reverse(TreeNode node) {
        if (node == null) return null;
        TreeNode temp = node.left;
        node.left = reverse(node.right);
        node.right = reverse(temp);
        return node;
    }
}