package APNADSA.Heap_PQ;

import java.util.*;
public class K_Nearest_Cars {
    /*
     * Time Complexity is N*LogN 
     * For every point we compare and add in Priority Queue (Add takes log n and for loop --> i =0 to n)
     * Space complexity log n
     */

    static class point implements Comparable<point>{
        int x;
        int y;
        int distsq;
        int pt;
        point(int x,int y,int distsq,int pt){
            this.x = x;
            this.y = y;
            this.distsq = distsq;
            this.pt = pt;
        }
        @Override
        public int compareTo(point previouslycreated){
            return this.distsq - previouslycreated.distsq; // sort in ascending order basis on Distsq
        }
    }

    public static ArrayList<Integer> Find_K_NearCars(int points[][],int k){

        ArrayList<Integer> ouput = new ArrayList<>();

        // Logic 
        PriorityQueue<point> pq = new PriorityQueue<>();
        for(int i = 0; i< points.length; i++){  // Time complexity is O( NLogN )
            int x = points[i][0] * points[i][0];
            int y = points[i][1] * points[i][1];
            int distsq = x + y ;
            pq.add(new point(x, y, distsq, i));
        }
        
        for(int i =0; i<k; i++){
            ouput.add(pq.remove().pt);
        }
        return ouput;
    }


    public static void main(String args[]){
        int points[][] = {{3,3},
                          {5,-1},
                          {-2,4}};
        int k = 2;
        System.out.println(Find_K_NearCars(points,k));
    }
}
