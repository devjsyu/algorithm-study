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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode a, TreeNode b) {
        // base condition
        if (a == null && b == null) {
            return true;
        }

        // mismatch case filtering 1
        if (a == null || b == null) {
            return false;
        }

        // mismatch case filtering 2
        if (a.val != b.val) {
            return false;
        }

        // recursive part
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}