package APNADSA.GraphDS;

import java.util.PriorityQueue;

public class ConnectingCities {

    public static class Edge implements Comparable<Edge>{
        int dest;
        int wt;
        Edge(int d, int w){
            dest = d;
            wt = w;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }

    public static int FindMinCost_to_ConnectAllCities(int [][]cities){
        int n = cities.length;
        boolean vis[] = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int finalCost = 0;
        pq.add(new Edge(0,0));

        while(!pq.isEmpty()){
            Edge curr = pq.remove();
            if(!vis[curr.dest]){
                vis[curr.dest] = true;
                finalCost += curr.wt;
                for(int i =0; i<cities[curr.dest].length; i++){
                    if(cities[curr.dest][i] != 0){
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }   
            
        }
        return finalCost;
    }
    public static void main(String[] args) {
        int cities [][] = {{0,1,2,3,4},
                            {1,0,5,0,7},
                            {2,5,0,6,0},
                            {3,0,6,0,0},
                            {4,7,0,8,0}};
        System.out.println(FindMinCost_to_ConnectAllCities(cities));
    }

}
