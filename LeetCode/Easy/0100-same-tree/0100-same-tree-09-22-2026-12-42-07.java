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
        this.list = new ArrayList<>();
        this.index = 0;

        dfsForP(p);
        return dfsForQ(q) && index == list.size();
    }

    private List<Integer> list;
    private int index;

    private void dfsForP(TreeNode node) {
        if (node == null) {
            list.add(null);
            return;
        }

        list.add(node.val);

        dfsForP(node.left);
        dfsForP(node.right);
    }

    private boolean dfsForQ(TreeNode node) {
        if (index >= list.size()) {
            return false;
        }

        if (node == null) {
            if (list.get(index) != null) {
                return false;
            } else {
                index++;
                return true;
            }
        }

        if (list.get(index) == null || list.get(index) != node.val) {
            return false;
        }

        index++;

        return dfsForQ(node.left) && dfsForQ(node.right);
    }
}