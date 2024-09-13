package APNADSA.GraphDS;

import java.util.*;
public class HasPath {

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
    // helper method 
    public static boolean findPath(ArrayList<Edge> graph[],int src,int dest,boolean visited[]){
        if(src == dest){
            return true;
        }

        visited[src] = true;

        for(int i = 0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest] && findPath(graph, e.dest, dest, visited)){
                return true;
            }
        }
        return false;
    }

    // actual method solved through DFS 
    public static boolean hasPath(ArrayList<Edge> graph[],int source, int destination){
        return findPath(graph,source,destination,new boolean[graph.length]);
    }
    public static void main(String[] args) {
        int  V = 7;
        
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        System.out.println(hasPath(graph, 0, 5)); // true
        System.out.println(hasPath(graph, 0, 7)); // false
   }
}
