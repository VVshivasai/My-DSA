package APNADSA.GraphDS;
import java.util.*;
public class BellManFordAlgorithm {

    public static class Edge {
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }      
    }

    // creation of graph 
    public static void CreateGraphByEgdes(ArrayList<Edge> graph, int V){
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0,2,4));
        graph.add(new Edge(0,3,1));
        graph.add(new Edge(1, 2, 3));
        graph.add(new Edge(1, 3, 9));
    }

    // BellManFord Algorithm
    public static void BMFA(ArrayList<Edge> graph,int source, int V){
        int dist[] = new int[V];
        for(int i = 0; i<V; i++){
            if(i!=source){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // bmfa 
        for(int i =0; i<V-1; i++){
            for(int j = 0;  j<graph.size(); j++){
                // edge of each node
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // shortest distance from src to every node
        for(int i= 0; i<dist.length; i++){
            System.out.print(dist[i] +" ");
        }
        
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph = new ArrayList<>();
        int source = 0;
        CreateGraphByEgdes(graph,V);
        BMFA(graph,source,V);
    }
}
