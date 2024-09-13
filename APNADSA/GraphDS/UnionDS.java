package APNADSA.GraphDS;

public class UnionDS {
    int[] rank,parent;

    public UnionDS(int n){
        rank = new int[n];
        parent = new int[n];
        init(n);
    }
    public void init(int n){
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // 1. Find Operation

    public int FindParent(int x){
        // path compression process
        if(x != parent[x]){
            parent[x] = FindParent(parent[x]);
        }
        return parent[x];
    }

    // 2. Union operation

    public void Union(int a, int b){
        int par_a = FindParent(a);
        int par_b = FindParent(b);

        if(rank[par_a] == rank[par_b]){
            parent[par_b] = par_a;
            rank[par_a]++;
        }else if(rank[par_a] < rank[par_b]){
            parent[par_a] = par_b;
        }else{
            parent[par_b] = par_a;
        }
    }

    public static void main(String args[]){
        UnionDS obj = new UnionDS(6);
        obj.Union(1, 3);
        obj.Union(3, 5);
        System.out.println(obj.FindParent(3));
        System.out.println(obj.FindParent(5));
    }
}
