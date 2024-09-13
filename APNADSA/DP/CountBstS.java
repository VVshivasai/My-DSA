package APNADSA.DP;

import java.util.Arrays;

public class CountBstS {

    public static int CountBst(int n, int dp[]){

        if(n == 0 || n == 1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        int PossibleBstS = 0;
        for(int i = 0; i<n; i++){
            PossibleBstS += CountBst(i, dp) * CountBst(n-i-1, dp);
        }
        
        return dp[n] = PossibleBstS;
    }
    public static void main(String[] args) {
        int n = 4;

        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(CountBst(n,dp)); // Using Memoization (Variation of Catalan number)
    }
}
