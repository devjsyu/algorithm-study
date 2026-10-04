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

    private boolean isMirror(TreeNode p, TreeNode q) {
        // base condition
        if (p == null && q == null) {
            return true;
        }

        // mismatch case filtering 1
        if (p == null || q == null) {
            return false;
        }

        // mismatch case filtering 2
        if (p.val != q.val) {
            return false;
        }

        // recursive part
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}