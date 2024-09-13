package APNADSA.QueueS;

import java.util.*;

/*
 * InterLeaves Problem 
 * Input [1,2,3,4,5,6,7,8,9,10]
 * output[1,6,2,7,3,8,4,9,5,10]
 * 
 * time compelxity --> O(N)
 * 
 * space complexity --> O(N)
 * 
 * 
 */

public class InterLeaves {


    public static Queue<Integer> Interleave(Queue<Integer> original){
        int n = original.size();
        Queue<Integer> firstHalf = new LinkedList<>();
        for(int i =1; i<=n/2; i++){
            firstHalf.add(original.remove());
        }

        while(!firstHalf.isEmpty()){
            original.add(firstHalf.remove());
            original.add(original.remove());
        }
        return original;
    }
    public static void main(String[] args) {
        Queue<Integer> original = new LinkedList<>();
        for(int i =1;i<= 10;i++){
            original.add(i);
        }
        System.out.println( "Input :" +original);
        System.out.println("Output :" +Interleave(original));
    }
}
