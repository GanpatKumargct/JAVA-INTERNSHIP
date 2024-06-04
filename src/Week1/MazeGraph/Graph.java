package Week1.MazeGraph;

import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int node1, int node2) {
        adjList.putIfAbsent(node1, new ArrayList<>());
        adjList.putIfAbsent(node2, new ArrayList<>());
        adjList.get(node1).add(node2);
        adjList.get(node2).add(node1); // Since it's an undirected graph
    }

    public List<Integer> getNeighbors(int node) {
        return adjList.getOrDefault(node, new ArrayList<>());
    }

    public Set<Integer> getNodes() {
        return adjList.keySet();
    }
}
