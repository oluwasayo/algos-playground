/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    left = p.val <= q.val ? p : q; right = p.val > q.val ? p : q;
    while (true) {
        if (root.val === left.val || root.val === right.val || (left.val < root.val && right.val > root.val)) return root;
        root = left.val > root.val ? root.right : root.left;
    }
};
