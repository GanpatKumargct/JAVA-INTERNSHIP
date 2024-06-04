package Week1.MazeGraph;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph mazeGraph = new Graph();
        // Define the edges of the maze
        mazeGraph.addEdge(0, 2);
        mazeGraph.addEdge(1, 4);
        mazeGraph.addEdge(2, 3);
        mazeGraph.addEdge(2, 5);
        mazeGraph.addEdge(3, 6);
        mazeGraph.addEdge(4, 5);
        mazeGraph.addEdge(4, 7);
        mazeGraph.addEdge(5, 6);
        mazeGraph.addEdge(5, 8);
        mazeGraph.addEdge(6, 9);
        mazeGraph.addEdge(7, 8);
        mazeGraph.addEdge(8, 9);

        int startNode = 1;
        int endNode = 9;

        List<Integer> path = MazeSolver.bfs(mazeGraph, startNode, endNode);

        if (path.isEmpty()) {
            System.out.println("No path exists from node " + startNode + " to node " + endNode);
        } else {
            System.out.println("Path from node " + startNode + " to node " + endNode + ": " + path);
        }
    }
}

