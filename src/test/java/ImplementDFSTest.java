import org.junit.Test;

import static org.junit.Assert.*;

public class ImplementDFSTest {

//    Implement a method to find a node in a graph using Depth First Search.
//    Example:
//    apple
//         /    \
//    banana   mango
//    /     \    /
//    peach   strawberry
//    \     /
//    cherry

//    Find cherry ==> true

    @Test
    public void depthFirstSearch() {
        Node apple = new Node("apple");
        Node banana = new Node("banana");
        Node mango = new Node("mango");
        Node peach = new Node("peach");
        Node strawberry = new Node("strawberry");
        Node cherry = new Node("cherry");
        apple.addAdjacentNode(banana);
        apple.addAdjacentNode(mango);
        banana.addAdjacentNode(peach);
        banana.addAdjacentNode(strawberry);
        mango.addAdjacentNode(strawberry);
        peach.addAdjacentNode(cherry);
        strawberry.addAdjacentNode(cherry);
        ImplementDFS implementDFS = new ImplementDFS();
        boolean mango1 = implementDFS.depthFirstSearch(apple, "mango");
        assertTrue(mango1);
        mango1 = implementDFS.depthFirstSearch(apple, "peach");
        assertTrue(mango1);
        mango1 = implementDFS.depthFirstSearch(apple, "strawberry");
        assertTrue(mango1);
        mango1 = implementDFS.depthFirstSearch(apple, "banana");
        assertTrue(mango1);
        mango1 = implementDFS.depthFirstSearch(apple, "cherry");
        assertTrue(mango1);

    }
}