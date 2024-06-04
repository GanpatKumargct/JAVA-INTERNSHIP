package Week1.MazeGraph;

import java.util.*;

class MazeSolver {
    public static List<Integer> bfs(Graph graph, int startNode, int endNode) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);
        parent.put(startNode, null);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (currentNode == endNode) {
                return constructPath(parent, endNode);
            }

            for (int neighbor : graph.getNeighbors(currentNode)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parent.put(neighbor, currentNode);
                }
            }
        }
        return new ArrayList<>(); // Return empty list if no path found
    }

    private static List<Integer> constructPath(Map<Integer, Integer> parent, int endNode) {
        List<Integer> path = new ArrayList<>();
        for (Integer node = endNode; node != null; node = parent.get(node)) {
            path.add(node);
        }
        Collections.reverse(path); // Reverse the path to get the correct order
        return path;
    }
}

