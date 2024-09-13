package APNADSA.GraphDS;

import java.util.*;
public class DijkstraAlgo {

    static class Edge{
        int src; 
        int dest;
        int wt;
        Edge(int s,int d,int wt){
            src = s;
            dest = d;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // vertex 1
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        // vertex 2
        graph[2].add(new Edge(2, 4, 3));

        // vertex 3 
        graph[3].add(new Edge(3, 5, 1));

        // vertex 4
        graph[4].add(new Edge(4, 5, 5));
        graph[4].add(new Edge(4, 3, 2));

        //vertex 5
        // No destination
    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int distance;
        Pair(int vertex,int distance){
            this.vertex = vertex;
            this.distance = distance;
        }
        @Override
        public int compareTo(Pair p2){
            return this.distance - p2.distance;
        }
    }

    // time complexity is O(V + E*logV)
    public static void DijKstra(ArrayList<Edge> graph[], int source){
        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(i != source){
                dist[i] = Integer.MAX_VALUE; // put + infinity to all expect source node
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.vertex]){
                vis[curr.vertex] = true;
                for(int i = 0; i< graph[curr.vertex].size(); i++){
                    Edge e = graph[curr.vertex].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // shortest distance logic
                    if(wt + dist[u] < dist[v]){
                        dist[v] = wt + dist[u];
                        // pass neighbour pair to pq
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // print all the shortest paths from source to all vertices
        for(int i =0; i<dist.length; i++){
            System.out.print(dist[i] + " ");
        }
    }
    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        DijKstra(graph,0);
    }
}
