/*
 * Title: Main.java
 * Description: Reads a list of integers and inserts them into a linked list in sorted order.
 *              Then prints the sorted list with consecutive sequences compressed using dash notation (e.g., 1-4).
 * Author: Shane Skare
 * Date: 03/18/2024
 */
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LinkedList<Integer> lList = new LinkedList<>();
        int size = s.nextInt();

        for (int i = 0; i < size; i++) {
            int nextNum = s.nextInt();
            findPlacement(nextNum, lList);
        }
        System.out.println(printList(lList));
        //System.out.println(lList);
    }
    private static String printList(LinkedList<Integer> lList) {
        StringBuilder complete = new StringBuilder();
        for(int i = 0; i < lList.size()-1; i++) {
            if(lList.get(i) + 1 == lList.get(i+1)){
                int start = lList.get(i);
                int end = lList.get(i+1);
                i++;
                for(int j = i; lList.get(j) + 1 == lList.get(j+1); j++){
                    end = lList.get(j+1);
                    if(end == lList.getLast()){
                        if(complete.toString().isEmpty()){
                            complete.append(start).append("-").append(end);
                        }
                        else{
                            complete.append(" ").append(start).append("-").append(end);
                        }
                        return complete.toString();
                    }
                    i++;
                }
                if(complete.toString().isEmpty()){
                    complete.append(start).append("-").append(end);
                }
                else{
                    complete.append(" ").append(start).append("-").append(end);
                }
            }
            else{
                if(complete.toString().isEmpty()) {
                    complete.append(lList.get(i));
                }
                else{
                    complete.append(" ").append(lList.get(i));
                }
            }
        }
        complete.append(" ").append(lList.getLast());
        return complete.toString();
    }
    private static void findPlacement(int num, LinkedList<Integer> lList) {
        if (lList.isEmpty() || num >= lList.getLast()) {
            lList.addLast(num);
        }
        else if(num <= lList.getFirst()){
            lList.addFirst(num);
        }
        else {
            int halfway = lList.size()/2;
            if (num == lList.get(halfway)){
                lList.add(halfway, num);
            }
            else if (num < lList.get(halfway)){
                for(int i = halfway-1; i >= 0; i = i/2){
                    if(num >= lList.get(i) && num <= lList.get(i+1)){
                        lList.add(i+1, num);
                        break;
                    }
                    else if(num > lList.get(i)){
                        i = i*3;
                    }
                }
            }
            else if ( num > lList.get(halfway)){
                for(int i = halfway+1; i < lList.size(); i = (i+lList.size())/2){
                    if(num <= lList.get(i) && num >= lList.get(i-1)){
                        lList.add(i, num);
                        break;
                    }
                    else if(num < lList.get(i)){
                        i = i/3;
                    }
                }
            }
        }
    }
}