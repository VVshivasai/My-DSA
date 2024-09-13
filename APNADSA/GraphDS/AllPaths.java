package APNADSA.GraphDS;

import java.util.*;

public class AllPaths {
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
        graph[0].add(new Edge(0, 3));
        
        // vertex 1

        // no destination

        // vertex 2
        graph[2].add(new Edge(2,3));

        //vertex 3
        graph[3].add(new Edge(3,1));

        //vertex 4
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4, 1));

        //vertex 5
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }
    public static void AllPaths_Src_To_Dest(ArrayList<Edge> graph[],int src,int dest, ArrayList<Integer> list){
        list.add(src);
        if(src == dest){
            System.out.println(list);
        }

        for(int i = 0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            AllPaths_Src_To_Dest(graph, e.dest, dest, list);
        }
        list.remove(list.size()-1); // back track
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 5, dest = 1;
        AllPaths_Src_To_Dest(graph,src,dest,new ArrayList<>());
    }
}
