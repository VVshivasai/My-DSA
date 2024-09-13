package APNADSA.DP;

import java.util.*;

public class _0_1KnapSack {

  
    // Brute Force --> Recursion 
    static int KnapSack1(int val[],int wt[], int W,int n){ // Recursion --> O(2^n)
        if(n == 0 || W==0){
            return 0;
        }
        if(wt[n-1] <= W){
            //Two choice 
            // 1. Include
            int include = val[n-1] + KnapSack1(val, wt, W-wt[n-1],n-1);
            // 2.Exclude
            int exclude = KnapSack1(val, wt, W, n-1);

            return Math.max(include,exclude);
        }else{ // case --> wt[n-1] > W
            return KnapSack1(val, wt, W, n-1);
        }
    }


    // --> Optimised
    // Memoization
    private static int Memo(int[] val, int[] wt, int W, int n,int dp[][]){
        if(n==0 || W==0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        // Two choices
        if(wt[n-1] <= W){
            //1.Include 
            int inc = val[n-1] + Memo(val, wt, W-wt[n-1], n-1, dp);
            //2.exclude
            int exc = Memo(val,wt,W,n-1,dp);

            // max of inc,exc
            return  dp[n][W] = Math.max(inc,exc);

        }else{ // wt[n-1] > W
            
            return dp[n][W] = Memo(val, wt, W, n-1, dp);
        }
    }
    // Mamoization
    private static int KnapSack2(int[] val, int[] wt, int W, int n) { // Memoization 
        int dp[][] = new int[n+1][W+1];

        for(int []row : dp){  // fill all the cells with -1
            Arrays.fill(row,-1);
        }

        int ans = Memo(val,wt,W,n,dp);
        return ans;
    }




     //Tabulation
    private static int KnapSack3(int val[],int wt[], int W,int n){
        // Create Table
        int dp[][] = new int[n+1][W+1];
        // Intialisation 
        for(int i = 0; i<n+1; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i<dp[0].length; i++){
            dp[0][i] = 0;
        }
        // find small to large cases solution 
        for(int i =1; i<n+1; i++){ // i is no. of items 
            for(int j = 1; j<W+1; j++){ // j is present capacity of bag
                //curr weight and its value
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j){
                    // include and exclude
                    dp[i][j] = Math.max(v + dp[i-1][j-w],dp[i-1][j]);
                }else { // w>j
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }


    
    public static void main(String[] args) {
        int val[] = {60,100,120};
        int wt[] = {10,20,30};
        int W = 50;
        //***If we try this with greedy it gives you 160 but possible max is 220 
        System.out.println(KnapSack1(val,wt,W,val.length)); // Recursion O(2^n)
        System.out.println(KnapSack2(val,wt,W,val.length)); // Memoization O(N*W)
        System.out.println(KnapSack3(val,wt,W,val.length)); // Tabulation O(N*W)
    }
}
