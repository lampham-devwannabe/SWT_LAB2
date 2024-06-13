import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = new Graph();
    }

    @AfterEach
    void tearDown() {
        graph = null;
    }

    @Test
    void testEmptyGraph() {
        assertFalse(graph.hasCycle());
    }

    @Test
    void testSingleNodeGraph() {
        graph.addEdge(1, 1);
        assertTrue(graph.hasCycle());
    }

    @Test
    void testGraphWithDisconnectedComponents() {
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        assertFalse(graph.hasCycle());
    }

    @Test
    void testGraphWithDisconnectedComponentsWithCycle() {
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 5);
        assertTrue(graph.hasCycle());
    }

    @Test
    void testBfsSingleNode() {
        graph.addEdge(1, 1);
        List<Integer> expected = List.of(1);
        assertEquals(expected, graph.bfs(1));
    }

    @Test
    void testBfsGraphWithCycle() {
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1); // Cycle here
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, graph.bfs(1));
    }

    @Test
    void testBfsDisconnectedGraph() {
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, graph.bfs(1));
    }

    @Test
    void testBfsDifferentStartNode() {
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2); // Cycle here
        List<Integer> expected = Arrays.asList(3, 4, 5, 2);
        assertEquals(expected, graph.bfs(3));
    }
}