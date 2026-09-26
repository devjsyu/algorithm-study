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

    private boolean isSame(TreeNode p, TreeNode q) {
        // base condition
        if (p == null && q == null) {
            return true;
        }

        // mismatch filtering 1
        if (p == null || q == null) {
            return false;
        }

        // mismatch filtering 2
        if (p.val != q.val) {
            return false;
        }

        // recursive part
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}