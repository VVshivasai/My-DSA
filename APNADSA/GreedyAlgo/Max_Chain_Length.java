package APNADSA.GreedyAlgo;
/*
 * You are given N pairs of numbers. In every pair, the first number is always smaller than the second number.
 * A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion.
 * You have to find the longest chain which can be formed from the given set of pairs. 
 */

import java.util.Arrays;
import java.util.Comparator;

public class Max_Chain_Length {

    public static int MaxChain(int [][]pairs, int n){
        int chainLen = 1;
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1])); // sort the second coloumn

        int PairEnd = pairs[0][1];
        for(int i =1;i<n;i++){
            int pairStart = pairs[i][0];
            if(pairStart>PairEnd){
                chainLen++;
                PairEnd = pairs[i][1];
            }
        }
        return chainLen;
    }
 public static void main(String[] args) {
    int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
    int n = pairs.length;
    System.out.println(MaxChain(pairs,n));
 }
}
