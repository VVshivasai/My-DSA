package APNADSA.GraphDS;
/*Purpose: 1.Prim’s algorithm is not used to find the shortest path between two nodes.
 *         2.Instead, it is used to ensure that all nodes in a graph are connected 
 *           with the minimum total edge weight.
 */

import java.util.*;



public class PrimsAlgorithm {
    static class Edge {
        int src;
        int dest;
        int wt;
        Edge(int s, int d, int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }
    
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        //vertex 0
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        //vertex 1
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        //vertex 2
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        //vertex 3
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 2, 50));

    }

    // Prims algo to find MST's weight

    static class Pair implements Comparable<Pair>{
        int vertex;
        int weight;
        Pair(int v, int w){
            vertex = v;
            weight = w;
        }
        @Override
        public int compareTo(Pair p2){
            return this.weight - p2.weight;
        }
    }
    public static int Prims(ArrayList<Edge> graph[]){

        boolean vis[] = new boolean[graph.length];
        int finalWeigth = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.vertex]){
                vis[curr.vertex] = true;
                finalWeigth += curr.weight;
                for(int i = 0; i<graph[curr.vertex].size(); i++){
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair(e.dest,e.wt));

                }
            }
        }
        return finalWeigth;
    }
    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("Minimun Spanning Tree,s Weight =  " + Prims(graph));
    }
}
