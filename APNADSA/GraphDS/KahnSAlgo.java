package APNADSA.GraphDS;
import java.util.*;

// Kahn's Algorithm : --> Topological sort using BFS
public class KahnSAlgo {

    static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            src = s;
            dest = d;
        }
    }

    public static void creteGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        //vertex 0
        //no destination

        // vertex 1
        // no destination
        
        //vertex 2
        graph[2].add(new Edge(2, 3));

        //vertex 3
        graph[3].add(new Edge(3,1));

        //vertex 4
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4, 1));

        //vertex 5
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // creating indegree array
    public static void createIndegree(ArrayList<Edge> graph[],int indeg[]){
        for(int i = 0; i<graph.length; i++){
            for(int j =0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    // topological sort 
    public static void topologicalSort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        createIndegree(graph,indeg);
        Queue <Integer> q = new LinkedList<>();
         //step 1: add elements which are  indeg[i] == 0
        for(int i =0;i<indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        // step 2 : remaining elements which are not indeg[element] != 0
        while(!q.isEmpty()){
            int curr  = q.remove();
            System.out.print(curr +" ");
            for(int i = 0; i< graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        creteGraph(graph);
        topologicalSort(graph);
    }
}
