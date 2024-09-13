package APNADSA.GreedyAlgo;

import java.util.*;;



public class Chacola_Problem {

    public static int MinCost_To_Cut_Chcolate( int n, int m, Integer []HorCost, Integer []VerCost){
        int cost = 0;

        Arrays.sort(HorCost, Collections.reverseOrder());
        Arrays.sort(VerCost, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        while(h < n-1 && v < m-1){
            if(HorCost[h] >= VerCost[v]){ // Horizontal Cut
                cost += HorCost[h] * hp;
                hp++;
                h++;
            }else{
                cost +=VerCost[v] * vp;  // Vertical Cut
                vp++;
                v++;
            }
        }

        while(h < n-1){
            cost += HorCost[h] * hp;
            hp++;
            h++;
        }

        while(v < m-1){
            cost += VerCost[v] * vp;
            vp++;
            v++;
        }

        return cost;
    }
    public static void main(String[] args) {
        int n = 4; // rows of Chocolate (Horizontal Cost)
        int m = 3; // coulumns of Chacolate (Vertical Cost)

        Integer HorCost[] ={4,1,2}; // length = n-1
        Integer VerCost[] ={2,1}; // length = m-1

        System.out.println(MinCost_To_Cut_Chcolate(n,m,HorCost,VerCost));
    }
}
