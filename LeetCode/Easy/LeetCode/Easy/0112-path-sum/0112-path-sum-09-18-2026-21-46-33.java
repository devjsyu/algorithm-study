import java.util.*;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        this.sum = 0;
        this.list = new ArrayList<>();

        this.answer = false;

        dfs(root);

        return answer;
    }

    private boolean answer;
    private int targetSum;
    private int sum;
    private List<Integer> list;

    private void dfs(TreeNode node) {
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

        dfs(node.left);
        dfs(node.right);

        sum -= node.val;
    }
}