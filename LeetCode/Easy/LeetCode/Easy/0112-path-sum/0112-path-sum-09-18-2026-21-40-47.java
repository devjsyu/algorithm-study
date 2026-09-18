import java.util.*;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        this.sum = 0;
        this.list = new ArrayList<>();

        dfs(root);

        for (int value : list) {
            if (value == targetSum) {
                return true;
            }
        }
        
        return false;
    }

    private int targetSum;
    private int sum;
    private List<Integer> list;

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        sum += node.val;

        if (node.left == null && node.right == null) {
            list.add(sum);
        }

        dfs(node.left);
        dfs(node.right);

        sum -= node.val;
    }
}