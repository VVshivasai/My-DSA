package APNADSA.GraphDS;
import java.util.*;
public class TopologicalSort {
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            src = s;
            dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        //vertex 0
        // N0 destination for 0 

        // vertex 1
        graph[1].add(new Edge(1,0));

        // vertex 2
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));

        //vertex 3
        graph[3].add(new Edge(3,4));

        //vertex 4
        graph[4].add(new Edge(4,0));

    }

    // topological sort using dfs and stack
    public static void topologicalSort(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<graph.length; i++){
            if(!vis[i]){
                topologicalUtil(graph,i,vis,st);
            }
        }
        // printing topological order
        while(!st.isEmpty()){
            System.out.print(st.pop() +" ");
        }
    }

    // topological function logic 
    public static void topologicalUtil(ArrayList<Edge> graph[],int curr,boolean vis[],Stack<Integer> st){
        vis[curr] = true;
        for(int i = 0; i<graph[curr].size(); i++){
            // neighbours of curr
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topologicalUtil(graph, e.dest, vis, st);
            }
        }
        st.push(curr);
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topologicalSort(graph);
    }
}
