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
    public List<List<Integer>> levelOrder(TreeNode root) {
        return bfs(root);
    }

    private List<List<Integer>> bfs(TreeNode start) {
        List<List<Integer>> values = new ArrayList<>();

        if (start == null) {
            return values;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {

            // 현재 레벨에 존재하는 노드 개수
            int levelSize = queue.size();

            // 현재 레벨의 값들을 저장
            List<Integer> levelValues = new ArrayList<>();

            // 현재 레벨의 노드만 처리
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                levelValues.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            values.add(levelValues);
        }

        return values;
    }
}