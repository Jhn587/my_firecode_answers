public class Edge {
    public final Vertex target; // Target node of the edge
    public final double weight; // Edge weight

    public Edge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
}
