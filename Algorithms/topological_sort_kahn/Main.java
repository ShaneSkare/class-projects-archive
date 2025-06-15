/*
 * Title: Main.java
 * Description: Implements Kahn's algorithm for topological sorting of a directed graph.
 *              Reads number of vertices and edges, builds an adjacency list, and outputs
 *              in-degrees followed by the topological order.
 * Author: Shane Skare
 * Date: 04/17/2024
 * Reference: https://www.geeksforgeeks.org/how-to-iterate-hashmap-in-java/
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        str.append("Order:");
        int vertices = s.nextInt();
        LinkedList<Integer>[] adjList = new LinkedList[vertices];
        HashMap<Integer, Integer> edgeCount = new HashMap<Integer, Integer>();

        for (int i = 0; i < vertices; ++i) {
            adjList[i] = new LinkedList<>();
            edgeCount.put(i, 0);
        }
        int edges = s.nextInt();
        for(int i = 0; i < edges; i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            adjList[v1].add(v2);
            edgeCount.put(v2, edgeCount.get(v2) + 1);
        }
        for (Map.Entry<Integer, Integer> set : edgeCount.entrySet()) {
            System.out.println("In-degree[" + set.getKey() + "]:" + set.getValue());
        }
        Queue<Integer> queue = new LinkedList<>();
        while (!edgeCount.isEmpty()) {
            if (edgeCount.containsValue(0)) {
                for (Map.Entry<Integer, Integer> set : edgeCount.entrySet()) {
                    if (set.getValue() == 0) {
                        queue.add(set.getKey());
                    }
                }
                while(!queue.isEmpty()){
                    for (int neighbor : adjList[queue.peek()]) {
                        edgeCount.put(neighbor, edgeCount.get(neighbor) - 1);
                    }
                    if (str.toString().equals("Order:")){
                        str.append(queue.peek());
                    }
                    else{
                        str.append("->").append(queue.peek());
                    }
                    edgeCount.remove(queue.poll());
                }
            } else {
                System.out.println("No Order:");
                return;
            }
        }
        System.out.println(str);
    }
}