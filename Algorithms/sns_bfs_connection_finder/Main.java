/*
 * Title: Main.java
 * Description: Performs a Breadth First Search (BFS) on a social network graph and
 *              prints all users who are exactly a specified degree of connection away
 *              from a given starting user.
 * Author: Shane Skare
 * Date: 03/19/2024
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, LinkedList<String>> graph = new HashMap<>();

        int nodes = s.nextInt();
        for(int i = 0; i < nodes; i++){
            graph.putIfAbsent(s.next(), new LinkedList<>());
        }
        int connections = s.nextInt();
        for(int i = 0; i < connections; i++){
            graph.get(s.next()).add(s.next());
        }

        String originPerson = s.next();
        int degreeOC = s.nextInt();
        bfs(graph, originPerson, degreeOC);
    }

    static void bfs(Map<String, LinkedList<String>> graph, String src, int degree) {
        Queue<String> q = new LinkedList<>();
        int count = 0;
        ArrayList<String> mark = new ArrayList<>(graph.size());
        HashMap<String, Integer> connectionDegree = new HashMap<>(graph.size());
        for (String name : graph.keySet()) {
            connectionDegree.put(name, -1);
        }

        mark.add(src);
        q.add(src);
        count = connectionDegree.get(src) + 1;
        connectionDegree.put(src, count);

        while (!q.isEmpty() && !connectionDegree.containsValue(degree)) {
            String curr = q.remove();
            for (int i = 0; i < graph.get(curr).size(); i++) {
                String neighbor = graph.get(curr).get(i);
                if (!mark.contains(neighbor)) {
                    mark.add(neighbor);
                    q.add(neighbor);
                    if(i == 0){
                        count++;
                    }
                    connectionDegree.put(neighbor, count);
                }
            }
        }
        if(q.isEmpty()){
            System.out.println("NONE");
            return;
        }
        ArrayList<String> sortedKeys = new ArrayList<String>(q);
        Collections.sort(sortedKeys);
        for (String x : sortedKeys)
            if(Objects.equals(x, sortedKeys.get(sortedKeys.size() - 1)))
                System.out.print(x);
            else
                System.out.print(x + ",");
    }
}