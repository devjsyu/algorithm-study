import java.util.*;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
				if (root == null) return false;
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode node, int targetSum, int sum) {
        sum += node.val;

        if (node.left == null && node.right == null) { //마지막 왔쪄염 뿌우
           return sum == targetSum;
        }
				
				
        if (node.left != null && dfs(node.left, targetSum, sum)) return true;
        if (node.right != null && dfs(node.right, targetSum, sum)) return true;

        return false;
    }
}