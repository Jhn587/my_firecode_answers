import java.util.Arrays;
import java.util.Objects;

class Vertex implements Comparable<Vertex> {
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous; // Previous optimal path node

    public Vertex(String argName) {
        name = argName;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Double.compare(vertex.minDistance, minDistance) == 0 &&
                Objects.equals(name, vertex.name) &&
                Arrays.equals(adjacencies, vertex.adjacencies) &&
                Objects.equals(previous, vertex.previous);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, minDistance, previous);
        result = 31 * result + Arrays.hashCode(adjacencies);
        return result;
    }
}
