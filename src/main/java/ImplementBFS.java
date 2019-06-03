import java.util.Objects;

/**
 * Implement the Breadth First Search Algorithm for a Graph
 * Implement a method to find a node in a graph using Breadth First Search. Click
 * 'Use me!' to inspect the Node class and its methods.
 * Example:
 * <p>
 * <p>
 * apple
 * /    \
 * banana   mango
 * /     \    /     Find
 * peach   strawberry
 * \     /
 * cherry
 * <p>
 * cherry ==> True
 */
public class ImplementBFS {

    public boolean breadthFirstSearch(Node rootNode, String data) {
        if (rootNode == null || rootNode.visited) {
            return false;
        }

        if (Objects.equals(data, rootNode.data)) {
            return true;
        }

        rootNode.visited = true;
        boolean toReturn = false;
        for (Node node : rootNode.adjacentNodes) {
            toReturn |= breadthFirstSearch(node, data);
        }
        return toReturn;
    }
}
