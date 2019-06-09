import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DjikstraTest {

    private Vertex rville;
    private Vertex bville;
    private Vertex gville;
    private Vertex oville;
    private Vertex pville;

    //    Rville -> Gville should [Rville, Bville, Gville]
//    Rville -> Oville should [Rville, Oville]
    @Test
    public void getShortestPath() {
        buildGraph();
        List<Vertex> shortestPath = Djikstra.getShortestPath(rville, gville);
        List<Vertex> expectedShortedPath = Arrays.asList(rville, bville, gville);
        Assert.assertEquals(expectedShortedPath, shortestPath);

        buildGraph();
        shortestPath = Djikstra.getShortestPath(rville, oville);
        expectedShortedPath = Arrays.asList(rville, oville);
        Assert.assertEquals(expectedShortedPath, shortestPath);
    }

    private void buildGraph() {
//        Implement a method to compute the shortest path from source to target in a graph using Djikstra Algorithm.
//        The method should return a List of Vertices denoting the optimal path.Click "Use Me" to understand the Vertex
//        and Edge
        rville = new Vertex("rville");
        bville = new Vertex("bville");
        gville = new Vertex("gville");
        oville = new Vertex("oville");
        pville = new Vertex("pville");

        //rville
        Edge rToG = new Edge(gville, 10);
        Edge rToB = new Edge(bville, 5);
        Edge rToO = new Edge(oville, 8);
        Edge[] rVillEdges = new Edge[]{rToG, rToB, rToO};
        rville.adjacencies = rVillEdges;

        //bville
        Edge bToP = new Edge(pville, 7);
        Edge bToG = new Edge(gville, 3);
        Edge[] bVillEdges = new Edge[]{bToP, bToG};
        bville.adjacencies = bVillEdges;

        //gville
        Edge gToB = new Edge(bville, 3);
        Edge[] gVillEdges = new Edge[]{gToB};
        gville.adjacencies = gVillEdges;

        //oville
        Edge oToP = new Edge(pville, 2);
        Edge[] oVillEdges = new Edge[]{oToP};
        oville.adjacencies = oVillEdges;

        //pville
        Edge[] pVillEdges = new Edge[0];
        pville.adjacencies = pVillEdges;
    }
}