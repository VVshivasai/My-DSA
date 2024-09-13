package APNADSA.DP;
import java.util.*;
public class CatalansNumber {
    // Using recursion Which takes so much time to compute
    public static int CatalanRec( int n ){
        if(n == 0 || n == 1){
            return 1;
        }

        int ans = 0;
        for(int i = 0; i<n; i++){
            ans += CatalanRec(i) * CatalanRec(n-i-1);
        }
        return ans;
    }
    // Using Memoization 
    public static int CatalanMemo(int n, int dp[]){
        if(n == 0 || n == 1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        int ans = 0;

        for(int i = 0; i<n; i++){
            ans += CatalanMemo(i, dp) * CatalanMemo(n-i-1, dp);
        }
        return dp[n] = ans;
    }

    // Using tabulation --> Time COmplexity O(N^2)

    public static int CatalanTabulation(int n){
        // Create Table 
        int dp[] = new int[n+1];
        //Intialization 
        dp[0] = dp[1] = 1;

        // Meaning or relation (small to large)

        for(int i = 2; i<n+1; i++){
            for(int j = 0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n = 5;

        System.out.println(CatalanRec(n)); // Using recursion

        // using memoization
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(CatalanMemo(n,dp)); // using memoization

        System.out.println(CatalanTabulation(n)); // Using Tabulation 
    }
}
