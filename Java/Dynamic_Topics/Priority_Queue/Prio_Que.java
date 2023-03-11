package Dynamic_Topics.Priority_Queue;

import java.util.PriorityQueue;

public class Prio_Que {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();

        pq.add(4);
        pq.add(1);
        pq.add(3);
        pq.add(2);
        pq.add(9);
        pq.add(7);

        //print the value of priority Queue
        System.out.println(pq);

    }
}
