import org.junit.Test;

import static org.junit.Assert.*;

public class HeightOfTreeTest {

    @Test
    public void findHeight() {
    }

    @Test
    public void size() {
        TreeNode two = buildTreeNodeWithHeightOfTwo();
        HeightOfTree heightOfBinaryTree = new HeightOfTree();
        int size = heightOfBinaryTree.findHeight(two);
        assertEquals(2,size);

    }

    private TreeNode buildTreeNodeWithHeightOfTwo() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(0);
        return treeNode;
    }
}