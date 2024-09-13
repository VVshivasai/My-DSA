package APNADSA.GraphDS;
import java.util.*;

public class IsCycleExists {

    static class Edge {
        int src;
        int dest;
        Edge(int s,int d){
            src=s;
            dest=d;        
        }
    }

    public static void creteGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        //vertex 0
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        // vertex 1
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        // vertex 2
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        //vertex 3
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));

        //vertex 4
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));

        //vertex 5
        graph[5].add(new Edge(5,6));

        //vertex 6
        graph[6].add(new Edge(6,5));
    }

    // dfs function
    public static boolean dfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(!vis[i]){
                if(dfsUtil(graph,i,vis,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    // dfs util function
    public static boolean dfsUtil(ArrayList<Edge> graph[],int src,boolean vis[],int par){
        vis[src] = true;
        for(int i = 0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            // case 1: not visited atleast one time
            if(!vis[e.dest]){
                if(dfsUtil(graph,e.dest,vis,src)){
                    return true;
                }
            }
            // case 2: visited but it is not be the  parent of e.dest which means par != src
            else if(vis[e.dest] && par != e.dest ){
                return true;
            }
        }
        return false;
    }
    // Time Complexity --> O(V+E)
    public static boolean IsCycle_Exists(ArrayList<Edge> graph[]){
        return dfs(graph);
    }
    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        creteGraph(graph);
        System.out.println(IsCycle_Exists(graph));
    }
}
