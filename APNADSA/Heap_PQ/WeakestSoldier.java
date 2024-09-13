package APNADSA.Heap_PQ;

import java.util.*;
public class WeakestSoldier {

    static class Row implements Comparable<Row>{
        int countSoldier;
        int row;
        Row(int countSoldier,int row){
            this.countSoldier = countSoldier;
            this.row = row;
        }
        @Override
        public int compareTo(Row previusObj){
            if(this.countSoldier == previusObj.countSoldier){  // object sort
                return this.row - previusObj.row;
            }else{ 
                return this.countSoldier - previusObj.countSoldier;
            }
        }
    }
    public static ArrayList<Integer> FindWeakestRow(int [][]army, int k){
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Row> pq = new PriorityQueue<>();
        // adding elem into queue and sort basis on soldiers 
        for(int i = 0; i< army.length;i++){
            int countSoldier=0;
            for(int j = 0;j<army[i].length;j++){
                countSoldier += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(countSoldier, i));
        }
        // add weakest soldiers to list
        for(int i = 0 ; i< k;i++){
            list.add(pq.remove().row);
        }
        return list;
    }
    public static void main(String args[]){
        int army[][]= {{1,0,0,0},
                      {1,1,0,0},
                      {1,1,1,0},
                      {1,1,1,1},
                      {1,0,0,0}};
        int k = 3;
        System.out.println(FindWeakestRow(army,k));
    }
}
