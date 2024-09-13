package APNADSA.GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

public class Fractional_KnapSack {

    public static int MaximumPrice(int []price,int []weight, int W){
        int n = price.length;
        int knapSack =0;
        double ratio[][] = new double[n][2];
        for(int i =0; i<n; i++){
            ratio[i][0] = i;
            ratio[i][1] = price[i]/(double)weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        for(int i = n-1;i>=0;i--){
            if(weight[(int)ratio[i][0]] <= W ){
                knapSack += price[(int)ratio[i][0]];
                W -= weight[(int)ratio[i][0]];
            }else{
                knapSack += ratio[i][1] * W;
                W = 0;
                break;
            }
        }
        return knapSack;
    }
    public static void main(String[] args) {
        int[] price = {60,100,120};
        int[] weight ={10,20,30};
        int W = 50;
        System.out.println(MaximumPrice(price,weight,W));
    }
}
