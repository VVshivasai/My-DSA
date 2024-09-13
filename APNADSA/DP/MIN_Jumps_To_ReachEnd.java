package APNADSA.DP;

import java.util.Arrays;

/*  https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1 
        gfg Problem link */


public class MIN_Jumps_To_ReachEnd {

    private static int Min_JumpsTo_end(int arr[]){
        int n = arr.length;
        
        // Create 1d DP table
        int dp[] = new int[n];
        
        // Intialization 
        Arrays.fill(dp,-1);
        dp[n-1] = 0;
        
        
        // find sol. for small to large
        for(int i = n-2; i>=0; i--){
            int ans = Integer.MAX_VALUE;
            int steps = arr[i];
            for(int j = i+1; j<n && j<=i+steps; j++){
                if(dp[j] != -1){
                    ans = Math.min(ans,dp[j]+1);
                }
            }
            dp[i] =  ans != Integer.MAX_VALUE ? ans : -1;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int arr[]= {2,3,1,1,4};
        System.out.println(Min_JumpsTo_end(arr)); // Using Tabulation (Variation of Kadanes Algo -1D DP )
    }
}
