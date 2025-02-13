package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;


import org.junit.Test;

public class DijkstrasTest {

    @Test
    public void testShortestPathFromAtoH() {
        Graph graph = createSampleGraph();
        List<Character> path = graph.getShortestPath('A', 'H');
        List<Character> expected = Arrays.asList('H', 'F', 'B');
        assertEquals(expected, path);
    }

    @Test
    public void testShortestPathFromAtoA() {
        Graph graph = createSampleGraph();
        List<Character> path = graph.getShortestPath('A', 'A');
        assertTrue(path.isEmpty());
    }


    private Graph createSampleGraph() {
        Graph g = new Graph();
        g.addVertex('A', Arrays.asList(new Vertex('B', 7), new Vertex('C', 8)));
        g.addVertex('B', Arrays.asList(new Vertex('A', 7), new Vertex('F', 2)));
        g.addVertex('C', Arrays.asList(new Vertex('A', 8), new Vertex('F', 6), new Vertex('G', 4)));
        g.addVertex('D', Arrays.asList(new Vertex('F', 8)));
        g.addVertex('E', Arrays.asList(new Vertex('H', 1)));
        g.addVertex('F', Arrays.asList(new Vertex('B', 2), new Vertex('C', 6), new Vertex('D', 8), new Vertex('G', 9), new Vertex('H', 3)));
        g.addVertex('G', Arrays.asList(new Vertex('C', 4), new Vertex('F', 9)));
        g.addVertex('H', Arrays.asList(new Vertex('E', 1), new Vertex('F', 3)));
        return g;
    }
}