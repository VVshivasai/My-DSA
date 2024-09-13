package APNADSA.GraphDS;

import java.util.*;
public class DFS_TRAVERSAL {

    public static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){

        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

         // vertex 0
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));
 
         // vertex 1
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));
        
        // vertex 2
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        //vertex 3
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        //vertex 4
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        //vertex 5
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        //vertex 6
        graph[6].add(new Edge(6,5,1));

    }

    // DFS traversal

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean visited[]){
        if(visited[curr]){
            return;
        }
        if(!visited[curr]){

            System.out.print(curr+" ");
            visited[curr] = true;
        }

        for(int i = 0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                DFS(graph,e.dest,visited);
            }
        }
    }
    public static void main(String[] args) {
        int V = 7; // vertices
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        //create graph
        createGraph(graph);
        DFS(graph,0,new boolean[V]);
    }
}
