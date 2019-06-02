import org.junit.Test;

import static org.junit.Assert.*;

public class SizeOfBinaryTreeTest {

    @Test
    public void size() {
        TreeNode three = buildTreeNodeWithSizeThree();
        SizeOfBinaryTree sizeOfBinaryTree = new SizeOfBinaryTree();
        int size = sizeOfBinaryTree.size(three);
        assertEquals(3,size);

    }

    private TreeNode buildTreeNodeWithSizeThree() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(2);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }
}