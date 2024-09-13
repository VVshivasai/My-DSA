package APNADSA.DP;

import java.util.*;

public class MountainRanges { // Varaition Catalan number

    // Using Memoization
    public static int Mountains(int n , int dp[]){
        if(n == 0 || n == 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int mountains = 0;
        for(int i = 0; i<n; i++){
            mountains += Mountains(i, dp)/*Inside ways */ * Mountains(n-i-1, dp)/*Outside ways */;
        }
        return dp[n] = mountains;
    }

    // Using Tabulation
    public static int MountainsTabulation(int n){
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i<n+1; i++){
            for(int j = 0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1]; 
                // dp[j] = inside ways
                // dp[i-j-1] = outside ways
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;

        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(Mountains(n,dp)); // using memoization

        System.out.println(MountainsTabulation(n)); // using Tabulation
    }
}
