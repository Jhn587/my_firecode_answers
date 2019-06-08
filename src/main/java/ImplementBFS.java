import java.util.*;

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
    public boolean breadthFirstSearchIterative(Node rootNode, String data) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(rootNode);
        while (!nodes.isEmpty()) {
            Node dequeue = nodes.poll();
            if (dequeue == null || visited.contains(dequeue)) {
                continue;
            }

            if (data.equals(dequeue.data)) {
                return true;
            }

            visited.add(dequeue);
            nodes.addAll(dequeue.adjacentNodes);
        }
        return false;
    }

    public boolean breadthFirstSearch(Node rootNode, String data) {
        if (rootNode == null || rootNode.visited) {
            return false;
        }

        if (Objects.equals(data, rootNode.data)) {
            return true;
        }

        rootNode.visited = true;
        for (Node node : rootNode.adjacentNodes) {
            if (breadthFirstSearch(node, data)) {
                return true;
            }
        }
        return false;
    }
}
