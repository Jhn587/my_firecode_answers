import org.junit.Test;

import static org.junit.Assert.*;

public class ImplementBFSTest {

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
    public void breadthFirstSearchIterative() {
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
        ImplementBFS implementBFS = new ImplementBFS();
        boolean mango1 = implementBFS.breadthFirstSearchIterative(apple, "mango");
        assertTrue(mango1);
        mango1 = implementBFS.breadthFirstSearchIterative(apple, "peach");
        assertTrue(mango1);
        mango1 = implementBFS.breadthFirstSearchIterative(apple, "strawberry");
        assertTrue(mango1);
        mango1 = implementBFS.breadthFirstSearchIterative(apple, "banana");
        assertTrue(mango1);
        mango1 = implementBFS.breadthFirstSearchIterative(apple, "cherry");
        assertTrue(mango1);
    }

    @Test
    public void breadthFirstSearch() {
        findNode("mango");
        findNode("peach");
        findNode("strawberry");
        findNode("banana");
        findNode("cherry");
    }

    private void findNode(String data) {
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
        ImplementBFS implementBFS = new ImplementBFS();
        boolean mango1 = implementBFS.breadthFirstSearch(apple, data);
        assertTrue(mango1);
    }
}