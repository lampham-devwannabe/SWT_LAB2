import java.util.*;

public class Graph {
    private final Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
    }

    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();

        for (Integer node : adjacencyList.keySet()) {
            if (dfs(node, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int current, Set<Integer> visited, Set<Integer> recursionStack) {
        if (recursionStack.contains(current)) {
            return true; // Found a cycle
        }
        if (visited.contains(current)) {
            return false;
        }

        visited.add(current);
        recursionStack.add(current);

        List<Integer> neighbors = adjacencyList.get(current);
        if (neighbors != null) {
            for (Integer neighbor : neighbors) {
                if (dfs(neighbor, visited, recursionStack)) {
                    return true;
                }
            }
        }

        recursionStack.remove(current);
        return false;
    }

    public List<Integer> bfs(int startNode) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startNode);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            List<Integer> neighbors = adjacencyList.get(node);
            if (neighbors != null) {
                for (Integer neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        return result;
    }
}

