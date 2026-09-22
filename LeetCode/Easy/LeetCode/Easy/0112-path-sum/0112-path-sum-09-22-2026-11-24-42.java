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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        bfs(root, targetSum, 0);
        return answer;
    }

    private boolean answer = false;

    private void bfs(TreeNode node, int targetSum, int sum) {
        if (node == null) {
            return;
        }

        sum += node.val;

        if (node.left == null && node.right == null) {
            if (sum == targetSum) {
                answer = true;
                return;
            }             
        }

        bfs(node.left, targetSum, sum);
        bfs(node.right, targetSum, sum);

        sum -= node.val;
    }
}