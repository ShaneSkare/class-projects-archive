/*
 * Title: Main.java
 * Description: Builds and prints a directed graph based on user input.
 *              Each node shows its connections in ascending order.
 *              Input includes node count, edge count, and edges.
 * Author: Shane Skare
 * Date: 02/13/2024
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int arraySize = s.nextInt();
        int edgeNumber = s.nextInt();

        LinkedList[] nodes = new LinkedList[arraySize];
        for(int i = 0; i < edgeNumber; i++) {
            int index = s.nextInt();
            if(index>=arraySize){
                System.out.print("Invalid graph.");
                return;
            }
            String ConnectedN = s.next() + "," + s.next();
            if (nodes[index] == null) {
                LinkedList<String> edge = new LinkedList<String>();
                edge.add(ConnectedN);
                nodes[index] = edge;
            }
            else{
                LinkedList edge = nodes[index];
                edge.add(ConnectedN);
                nodes[index] = edge;
            }
        }
        for(int i = 0; i < arraySize; i++){
            System.out.print(i);
            if(nodes[i] != null) {
                LinkedList edge = nodes[i];
                Collections.sort(edge);
                for(Object conn : edge){
                    System.out.print("->" + conn);
                }
            }
            System.out.println();
        }
    }
}

