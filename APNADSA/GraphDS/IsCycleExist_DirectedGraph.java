package APNADSA.GraphDS;

import java.util.*;

public class IsCycleExist_DirectedGraph {

    public static class Edge {
        int src; int dest;
        Edge(int s, int d){
            src = s;
            dest = d;
        }
    }

    // create directed graph
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
        graph[4].add(new Edge(4,2));

    }

    // dfs approach for is Cycle in Directed graph
    public static boolean isCycleExist(ArrayList<Edge> graph[]){
        // create two arrays one is for visited and other to track stack calls
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(!vis[i]){
                if(isCycleUtil(graph,i,vis,stack)){
                    return true;
                }
            }
        }
        return false;
    }

    // logic to find cycle 
    public static boolean isCycleUtil(ArrayList<Edge> graph[],int src,boolean vis[],boolean stack[]){
        vis[src] = true;
        stack[src] = true;

        // src neighbours
        for(int i = 0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(stack[e.dest]){
                return true; // cycle exists
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)){
                return true;
            }
        }
        // is cycle does't exists
        // remove elements from stack 
        stack[src] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycleExist(graph));
    }
}
/*        Graph given : there is a cycle (2---> 3 ---> 4 --->2 )      
 *      1 -----> 0 <------2
 *                      /   /\
 *                     /     \
 *                    \/      \
 *                    3 ------> 4
 */