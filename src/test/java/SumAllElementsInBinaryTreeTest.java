import org.junit.Test;

import static org.junit.Assert.*;

public class SumAllElementsInBinaryTreeTest {

    @Test
    public void sum() {
        TreeNode three = buildTreeNodeWithSizeThree();
        SumAllElementsInBinaryTree sizeOfBinaryTree = new SumAllElementsInBinaryTree();
        int size = sizeOfBinaryTree.sum(three);
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