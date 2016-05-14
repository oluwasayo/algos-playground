/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
 
 var paths = [];

/**
 * @param {TreeNode} root
 * @return {string[]}
 */
var binaryTreePaths = function(root) {
    paths = [];
    if (root !== null) explore(root, []);
    return paths;
};

function explore(root, partialPath) {
    partialPath.push(root.val);
    if (root.left !== null) explore(root.left, partialPath);
    if (root.right !== null) explore(root.right, partialPath);
    if (root.left === null && root.right === null) paths.push(partialPath.join("->"));
    partialPath.pop();
}
