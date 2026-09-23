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
 /**
 DFS로 순회하면서 subRoot의 node 값이 나오는지 탐색
 isSameTree 메서드에 두 개의 매개변수로서 각 node 입력
  */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // subRoot 노드의 값과 일치하는지 탐색
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        if (a == null) {
            return false;
        }

        if (a.val == b.val) {
            if (isSameTree(a, b)) {
                return true;
            }
        }

        return dfs(a.left, b) || dfs(a.right, b);
    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        // base condition
        if (a == null && b == null) {
            return true;
        }

        // mismatch filtering
        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        // recursive part
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}