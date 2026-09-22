/*
class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 */
/**
 * Tree DFS Templates
 *
 * Pattern 1: Traverse every node
 * Pattern 2: Check whether something exists
 * Pattern 3: Return information from subtrees
 */
class TreeDFS {
    // ========================================
    // 1. Basic traversal
    // ========================================

    void traverse(TreeNode node) {
        // base case
        if (node == null) {
            return;
        }

        // process current node
        // process(node);

        // visit children
        traverse(node.left);
        traverse(node.right);
    }


    // ========================================
    // 2. Boolean / existence search
    // ========================================

    boolean exists(TreeNode node) {
        // base case
        if (node == null) {
            return false;
        }

        // check current node
        // if (condition(node)) {
        //     return true;
        //}

        // search left/right subtree
        return exists(node.left) || exists(node.right);
    }


    // ========================================
    // 3. Return subtree information
    // ========================================

    int calculate(TreeNode node) {
        // base case
        if (node == null) {
            return 0;
        }

        // get results from children
        int left = calculate(node.left);
        int right = calculate(node.right);

        // calculate current result
        // combine current node + child results
        return node.val + left + right;
    }
}