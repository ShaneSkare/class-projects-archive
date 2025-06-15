/*
 * Title: Main.java
 * Description: Performs a breadth-first search (BFS) on a directed graph using an adjacency list.
 *              Starting from vertex 0, it traverses all reachable nodes. If disconnected components
 *              are found, the program prints an edge that would connect them to the main graph.
 * Author: Shane Skare
 * Date: 04/04/2024
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int vertices = s.nextInt();
        LinkedList<Integer>[] adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i) {
            adjList[i] = new LinkedList<>();
        }
        int edges = s.nextInt();
        for(int i = 0; i < edges; i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            adjList[v1].add(v2);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        int startNode = 0;
        visited[startNode] = true;
        queue.add(startNode);
        int counter = 0;
        String sequence = "No new edge:";
        while (!queue.isEmpty()) {

            int currentNode = queue.poll();

            for (int neighbor : adjList[currentNode]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
            if (queue.isEmpty()){
                for (int i = 0; i < visited.length; i++){
                    if (!visited[i]){
                        counter++;
                        visited[i] = true;
                        queue.add(i);
                        if(counter > 1) {
                            sequence = "\nEdge: " + startNode + "-" + i;
                        }
                        else{
                            sequence = "Edge: " + startNode + "-" + i;
                        }
                        System.out.print(sequence);
                        startNode = i;
                        break;
                    }
                }
                if (sequence.equals("No new edge:")){
                    System.out.print(sequence);
                }
            }
        }
    }
}
