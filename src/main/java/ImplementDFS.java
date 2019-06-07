import java.util.HashSet;
import java.util.Set;

/**
 * Graph Depth First Search
 * Implement a method to find a node in a graph using Depth First Search.
 * Example:
 *           apple
 *          /    \
 *      banana   mango
 *     /     \    /
 *  peach   strawberry
 *     \     /
 *      cherry
 *
 * Find cherry ==> true
 */
public class ImplementDFS {
    private Set<Node> visited = new HashSet<>();
    public boolean depthFirstSearch(Node rootNode, String data){
        if(rootNode == null || visited.contains(rootNode)){
            return false;
        }

        visited.add(rootNode);

        for (Node node : rootNode.adjacentNodes) {
            if(depthFirstSearch(node, data)){
                this.visited = new HashSet<>();
                return true;
            }
        }
        return rootNode.data.equals(data);
    }
}
