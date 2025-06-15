/*
 * Title: Main.java
 * Description: Reads a directed graph and performs a Depth First Search (DFS).
 *              Outputs the mark (discovery order) for each node and the full visit sequence.
 * Author: Shane Skare
 * Date: 03/09/2024
 */
import java.util.*;
public class Main {
    private static int[][] graph;
    private static HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
    private static Stack<Integer> stack = new Stack<Integer>();
    private static int nodes, counter = 2;
    private static String sequence = "Visiting sequence:";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        nodes = s.nextInt();
        int edges = s.nextInt();
        graph = new int[nodes][nodes];

        for (int i = 0; i < edges; i++) {
            graph[s.nextInt()][s.nextInt()] = 1;
        }

        int startingVertex = s.nextInt();
        visited.put(startingVertex, 1);
        stack.add(startingVertex);
        sequence += startingVertex;
        dfs();
        for(int i = 0; i < nodes; i++){
            System.out.println("Mark[" + i + "]:" + visited.get(i));
        }
        System.out.println(sequence);
    }
    public static int dfs(){

            for (int i = 0; i < nodes; i++) {
                if (graph[stack.peek()][i] == 1 && !visited.containsKey(i)) {
                    visited.put(i, counter);
                    counter++;
                    stack.add(i);
                    sequence += "->" + i;
                    dfs();
                }
            }
            stack.pop();

        return 0;
    }
}