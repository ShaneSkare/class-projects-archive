/*
 * Title: Main.java
 * Description: Solves the Traveling Salesman Problem (TSP) using backtracking.
 *              Reads a directed graph with weighted edges and finds the lowest-cost
 *              path that visits all nodes and returns to the start node.
 * Author: Shane Skare
 * Date: 03/01/2024
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int[][] graph;
    private static boolean[] visited;
    private static int minimumCost = Integer.MAX_VALUE, newCost;
    private static List<Integer> bestPath = new ArrayList<>();

    private static void findBestPath(int start, ArrayList<Integer> path, int cost) {
        int lastNode = path.get(path.size() - 1);
        if (path.size() == graph.length && graph[lastNode][start] > 0) {
            newCost = cost + graph[lastNode][start];
            if(newCost == minimumCost){
                bestPath.remove(bestPath.size() - 1);
                return;
            }
            if (newCost < minimumCost) {
                minimumCost = newCost;
                bestPath = new ArrayList<>(path);
                bestPath.add(start);
            }
            return;
        }

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && graph[lastNode][i] > 0) {
                visited[i] = true;
                path.add(i);
                newCost = cost + graph[lastNode][i];
                findBestPath(start, path, newCost);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int node = s.nextInt();
        int edge = s.nextInt();
        graph = new int[node][node];
        visited = new boolean[node];

        for (int i = 0; i < edge; i++) {
            graph[s.nextInt()][s.nextInt()] = s.nextInt();
        }

        int startVertex = s.nextInt();
        visited[startVertex] = true;
        ArrayList<Integer> path = new ArrayList<>();
        path.add(startVertex);

        findBestPath(startVertex, path, 0);

        if (bestPath.isEmpty()) {
            System.out.println("Path:\nCost:-1");
        } else if (bestPath.size() <= node) {
            System.out.println("Multiple Paths\nCost:" + minimumCost);
        } else {
            System.out.print("Path:");
            for (int i = 0; i < bestPath.size(); i++) {
                System.out.print(bestPath.get(i));
                if (i < bestPath.size() - 1) {
                    System.out.print("->");
                }
            }
            System.out.println("\nCost:" + minimumCost);
        }
        s.close();
    }
}
