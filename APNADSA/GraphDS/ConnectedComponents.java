package APNADSA.GraphDS;

import java.util.*;
public class ConnectedComponents {
    public static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int wt){
            src =s;
            dest = d;
            this.wt=wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

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

        //vertex 4
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));

        //vertex 5
        graph[5].add(new Edge(5,6,1));

        //vertex 6
        graph[6].add(new Edge(6,5,1));
    }

    // BFS TRAVERSAL
    public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(!vis[i]){
                bfsUtil(graph,i,vis);
            }
        }
    }

    // BFS Util function to traverse through graph
    public static void bfsUtil(ArrayList<Edge> graph[],int src ,boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr +" ");
                vis[curr] = true;
            }
            for(int i =0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if(!vis[e.dest]){
                    q.add(e.dest);
                }
            }
        }
    }

    // DFS TRAVESRAL
    public static void dfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(!vis[i]){
                dfsUtil(graph,i,vis);
            }
        }
    }
    // dfs util function 
    public static void dfsUtil(ArrayList<Edge> graph[],int src,boolean vis[]){
        System.out.print(src +" ");
        vis[src] = true;

        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph,e.dest,vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph);
        System.out.println();
        dfs(graph);
    }
}
