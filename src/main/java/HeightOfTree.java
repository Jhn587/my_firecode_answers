/**
 * Height of a Binary Tree
 * Given a binary tree, write a method to find its height recursively.
 * An empty tree has a height of 0.
 * <p>
 * Example:
 * 1
 * / \
 * 2   3     ==> height=3
 * / \ / \
 * 4  5 6  7
 */
public class HeightOfTree {
    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));

    }
}
