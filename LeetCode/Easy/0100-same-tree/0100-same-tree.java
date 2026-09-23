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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        // current comparison

        // 1. base condition
        if (a == null && b == null) {
            return true;
        }

        // 2. mismatch filtering
        if (a == null || b == null) {
            return false;
        }

        // from now on, both left and right are guaranteed to be not null

        if (a.val != b.val) {
            return false;
        }

        // next comparison

        // 3. recursive part
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}