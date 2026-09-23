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

    private boolean isMirror(TreeNode left, TreeNode right) {
        // base condition
        if (left == null && right == null) {
            return true;
        }

        // 불일치 조건 1
        // 한 쪽만 null인 경우 필터링
        if (left == null || right == null) {
            return false;
        }

        // 위 필터링 이후 모두 null이 아님을 보장

        // 불일치 조건 2
        if (left.val != right.val) {
            return false;
        }

        // recursive part
        return isMirror(left.left, right.right) 
            && isMirror(left.right, right.left);
    }
}