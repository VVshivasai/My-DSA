package APNADSA.GraphDS;

import java.util.*;
/*1.Adjecency graph
 * Array of Lists is known as Adjececny graph
 */
public class GraphImplementation {
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s,int d,int wt){
            this.src = s;
            this.dest = d;
            this.weight = wt;
        }
    }


    public static void main(String args[]){
        int v = 5;
        // int arr[] = new int[size]
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        for(int i = 0; i<v; i++){
            graph[i] = new ArrayList<>();
        }
        //vertex 0
        graph[0].add(new Edge(0, 1, 5));

        //vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));
        
        //vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        //vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3,2,1));
        
        //vertex 4
        graph[4].add(new Edge(4, 2, 2));

        // accessing neighbours
        for(int i =0; i<graph[1].size(); i++){
            Edge e1 = graph[1].get(i);
            System.out.print(e1.dest +" ");
        }
       
    }
}
