/*
 * Title: Main_hw11_2.java
/*
 * Title: Main.java
 * Description: Implements the Floyd-Warshall algorithm to compute the shortest
 *              paths between all pairs of vertices in a weighted graph given
 *              as an adjacency matrix. Handles unreachable nodes using -1.
 * Author: Shane Skare
 * Date: 05/06/2024
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int vertices = s.nextInt();
        int graph[][] = new int[vertices][vertices];

        for (int i = 0; i < vertices; ++i) {
            for (int j = 0; j < vertices; ++j) {
                int num = s.nextInt();
                graph[i][j] = num;
            }
        }
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if ((graph[i][k] + graph[k][j] < graph[i][j] || graph[i][j] == -1) && graph[i][k] != -1 && graph[k][j] != -1)  {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < vertices; ++i) {
            for (int j = 0; j < vertices; ++j) {
                if (j == vertices - 1){
                    System.out.print(graph[i][j]);
                }
                else {
                    System.out.print(graph[i][j] + "   ");
                }
            }
            if (i != vertices-1) {
                System.out.println();
            }
        }
    }
}