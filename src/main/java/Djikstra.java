import java.util.*;

/**
 * Implement the Djikstra Shortest Path Algorithm in a Graph
 * Implement a method to compute the shortest path from source to target in a graph
 * using Djikstra Algorithm. The method should return a List of Vertices denoting
 * the optimal path. Click "Use Me" to understand the Vertex and Edge classes.
 * <p>
 * Example:
 * <p>
 * V2
 * |   \
 * |10  \3
 * |   5 \    7
 * V0 ——-- V1 ——— V4
 * \          /
 * \8       /2
 * \      /
 * V3
 * <p>
 * v0 = Rville
 * v1 = Bville
 * v2 = Gville
 * v3 = Oville
 * v4 = Pville
 * <p>
 * Shortest Path to V3 from V0 = [Rville, Oville]
 */

public class Djikstra {
    public static List<Vertex> getShortestPath(Vertex source, Vertex target) {
        PriorityQueue<Vertex> nodes = new PriorityQueue<>();
        Set<Vertex> visited = new HashSet<>();
        source.minDistance = 0;
        nodes.add(source);

        while (!nodes.isEmpty()) {
            Vertex closest = nodes.poll();
            if (visited.contains(closest)) {
                continue;
            }

            for (Edge edge : closest.adjacencies) {
                Vertex nextVertex = edge.target;
                double weight = edge.weight;
                double distanceToReachThroughThisPath = closest.minDistance + weight;
                if (distanceToReachThroughThisPath < nextVertex.minDistance) {
                    nextVertex.minDistance = distanceToReachThroughThisPath;
                    nextVertex.previous = closest;
                    //do i need to remove things from visited if this happens?
                }
                nodes.add(nextVertex);
            }


            visited.add(closest);
        }

        List<Vertex> path = new ArrayList<>();
        while (target != null) {
            path.add(target);
            target = target.previous;
        }
        Collections.reverse(path);
        return path;
    }

}
