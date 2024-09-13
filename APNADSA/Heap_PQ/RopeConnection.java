package APNADSA.Heap_PQ;
import java.util.*;
public class RopeConnection {

    public static int Find_Min_Cost(int []ropes){

        int cost  = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // adding all ropes to queue
        for(int i = 0 ; i< ropes.length; i++){
            pq.add(ropes[i]);
        }
        // take two min ropes and make new rope , calculate cost

        while(pq.size() > 1){
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += min1 + min2;
            pq.add(min1+min2);
        }
        System.out.println("Length of Rope :" + pq.peek());
        return cost;
    }

    public static void main(String args[]){
        int ropes[] = {3,1,2,4,6};
        System.out.println("Cost to Make rope :" + Find_Min_Cost(ropes));
    }

}
