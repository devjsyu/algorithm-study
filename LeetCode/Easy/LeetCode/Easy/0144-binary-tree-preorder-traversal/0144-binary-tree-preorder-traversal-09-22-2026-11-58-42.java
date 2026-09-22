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
    public List<Integer> preorderTraversal(TreeNode root) {
        this.list = new ArrayList<>();

        dfs(root);

        return list;
    }

    private List<Integer> list;

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        list.add(node.val);

        dfs(node.left);
        dfs(node.right);
    }
}