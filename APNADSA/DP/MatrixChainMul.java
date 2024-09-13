package APNADSA.DP;
/*
 * DP --> Partition Patterns MCM Problem 
 * Using Recursion --> 2^N
 */

 import java.util.*;
public class MatrixChainMul {

    public static int MCM_Rec( int arr[], int i, int j){
        if( i== j){
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for(int k = i; k<j; k++){
            int c1 = MCM_Rec(arr,i,k);// Ai ... Ak
            int c2 = MCM_Rec(arr, k+1, j);// Ak+1 .. Aj
            int c3 = arr[i-1] * arr[k] * arr[j];// Self 

            ans = Math.min(ans,c1+c2+c3); // Minimum of All Partition 
        }

        return ans;
    }

    public static int MCM_Memo(int arr[], int dp[][], int i , int j){
        if(i==j){
            return 0;
        }
        if(dp[i][j] != -1){ 
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for(int k = i; k<j; k++){
            int c1 = MCM_Memo(arr, dp, i, k); // Ai ... Ak
            int c2 = MCM_Memo(arr, dp, k+1, j); // Ak+1 .. Aj
            int c3 = arr[i-1] * arr[k] * arr[j]; // Self 

            ans = Math.min(ans,c1+c2+c3); // Minimum of All Partition 
        }

        return dp[i][j] = ans;  // Final answwer stored in dp[1][n-1];,Store ans in dp[i][j] to Avoid repeated calls
    }

    public static int Tabulation(int arr[],int n){
        //Create Table

        int dp[][] = new int[n][n];

        // Inatialization --> Which means base case (i==j) is 0
        for(int i = 1; i<n; i++){
            dp[i][i] = 0;
        }
        
        // Solve in Botttom -Up Manner (small to large)

        for(int len = 2; len < n; len++){
            for(int i = 1; i<n-len+1; i++){ // Rows --> i
                int j = i+len -1; // Coloumn --> j
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k<j; k++){
                    int c1 = dp[i][k];
                    int c2 = dp[k+1][j];
                    int c3 = arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j],c1+c2+c3);
                }
            }
        }
        return dp[1][n-1]; // Final Answer stored in it Because the table filled in diagoanl Manner
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,5};
        int n = arr.length;
        System.out.println(MCM_Rec(arr,1,n-1)); // Using Recursion

        // Using Memoization
        int dp[][] = new int[n][n]; // Variables are  i,j

        for(int ar[] : dp){
            Arrays.fill(ar,-1);
        }


        System.out.println(MCM_Memo(arr,dp,1,n-1)); // Using Memoization --> O(N^2)

        System.out.println(Tabulation(arr,n)); // Using Tabulation --> O(N^2)
    } 


}
