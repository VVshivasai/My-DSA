package APNADSA.GraphDS;

import java.util.*;

public class IsBipartite {

    public static class Edge{
        int src ;
        int dest ;
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
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        // vertex 1
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        // vertex 2
        graph[2].add(new Edge(2,0));


        //vertex 3
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));

        //vertex 4
        graph[4].add(new Edge(4,3));

        //vertex 5
        graph[5].add(new Edge(5,6));

        //vertex 6
        graph[6].add(new Edge(6,5));
    }
    //bfs function to check all components are bipartite or not
    public static boolean bfs(ArrayList<Edge> graph[]){
        int colour[] = new int[graph.length];
        for(int i = 0; i<colour.length; i++){
            colour[i] = -1; // intially no colour which means not visited
        }
        for(int i = 0; i<graph.length; i++){
            if(colour[i] == -1){
                if(!bfsUtil(graph,i,colour)){
                    return false;
                }
            }
        }
        return true;
    }

    // checking that each component is bipartite or not
    public static boolean bfsUtil(ArrayList<Edge> graph[],int src,int colour[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        colour[src] = 0;
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int i = 0; i<graph[curr].size(); i++){ // neighbours of curr 
                Edge e = graph[curr].get(i);
                // case 1 : not visited which means not coloured till now
                if(colour[e.dest] == -1){
                    int nextColour = colour[curr] == 0 ? 1 : 0;
                    colour[e.dest] = nextColour;
                    q.add(e.dest);
                }
                // case 2: coloured(visited) but if colour of curr == e.dest then invalid so return false
                if(colour[curr] == colour[e.dest]){
                    return false;
                }
            }
        }

        return true;
    }

    // is bipartite method
    public static boolean Is_Bipartite(ArrayList<Edge> graph[]){
        return bfs(graph);
    }
    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(Is_Bipartite(graph));
        
    }
}
