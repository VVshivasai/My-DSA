package APNADSA.GraphDS;


import java.util.*;

public class KruskalAlgo {

    public static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }
    //CREATION OF GRAPH
    public static void  createGraph(ArrayList<Edge> graph,int V){
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));
        graph.add(new Edge(0, 3, 30));
    }

    static int parent[] = new int[4];
    static int rank[] = new int[4];

    public static void init(int n){
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }

    //find operation
    public static int FindPar(int x){
        if(x!=parent[x]){
            parent[x] = FindPar(parent[x]);
        }
        return parent[x];
    }
    //find union
    public static void Union(int source, int destination){
        int par_a = FindPar(source);
        int par_b = FindPar(destination);
        if(rank[par_a] == rank[par_b]){
            parent[par_b] = par_a;
            rank[par_a]++;
        }else if(rank[par_a] < rank[par_b]){
            parent[par_a] = par_b;
        }else{
            parent[par_b] = par_a;
        }
    }

    // Kruskal's algorithm --> Weight of MST(min spanning tree)
    public static int Kruskal(ArrayList<Edge> graph,int V){
        init(V);
        Collections.sort(graph); //1.sort based on wt of edge
        int finalCost = 0;
        int count = 0;
        for(int i = 0; count < V-1; i++){
            Edge e = graph.get(i);
            int Par_src = FindPar(e.src);
            int Par_dst = FindPar(e.dest);
            if(Par_src != Par_dst){
                Union(e.src, e.dest);
                count ++;
                finalCost += e.wt;
            }
        }
        return finalCost;
    }


    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph,V);
        System.out.println(Kruskal(graph, V));
    }
}
