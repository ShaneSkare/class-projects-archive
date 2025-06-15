/*
 * Title: Main.java
 * Description: Processes customers based on priority levels using a HashMap and queues.
 *              Supports listing, adding, and deleting customers by priority order.
 * Author: Shane Skare
 * Date: 02/22/2024
 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<Integer, Queue<String>> map = new HashMap<>();
        ArrayList<Integer> priorityList = new ArrayList<Integer>();

        int num = s.nextInt();

        for (int i = 0; i < num; i++) {
            String name = s.next();
            int priority = s.nextInt();
            if(map.containsKey(priority)){
                Queue<String> list = map.get(priority);
                list.add(name);
                map.put(priority,list);
            } else{
                Queue<String> list = new LinkedList<>();
                list.add(name);
                map.put(priority,list);
                priorityList.add(priority);
            }
        }

        int num2 = s.nextInt();
        for (int i = 0; i < num2; i++) {
            String option = s.next();

            if(option.equals("List")){
                Collections.sort(priorityList);
                for(int j = 0; j < priorityList.size(); j++){
                    Queue<String> list = map.get(priorityList.get(j));
                    for (String string : list) {
                        System.out.println(string + " " + priorityList.get(j));
                    }
                }
            }
            if(option.equals("Add")){
                String name = s.next();
                int priority = s.nextInt();
                if(map.containsKey(priority)){
                    Queue<String> list = map.get(priority);
                    list.add(name);
                    map.put(priority,list);
                } else{
                    Queue<String> list = new LinkedList<>();
                    list.add(name);
                    map.put(priority,list);
                    priorityList.add(priority);
                }
                System.out.println(name + " added");
            }
            if(option.equals("Delete")){
                Collections.sort(priorityList);
                Queue<String> list = map.get(priorityList.get(0));
                System.out.println(list.poll() + " deleted");
                if(list.isEmpty()){
                    map.remove(priorityList.get(0));
                    priorityList.remove(0);
                }
            }
        }

    }

}