package APNADSA.DP;

public class UnboundKP {

    // minute change in KnapSack will get logic of Unbound KP
    // Time Complexity --> O(n*W)
    private static int unboundKP(int val[], int wt[], int W){ // Tabulation --> Bottom Up Approach
        int n = val.length;
        // 1.Create Table 
        int dp[][] = new int[n+1][W+1];

        // 2.Intialization
        // In java intially in int array vals are 0 so 0th items are 0 and 0th weight are 0
        // 3. Relation of (i(No. of items),j(capacity))

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<W+1; j++){
                if(wt[i-1] <= j){
                    // two choices 
                    //1. Include the item for how many times you want 
                    //2. Not include the item 
                    // choose max profit by compare both
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]],dp[i-1][j]);
                }else{ // wt[i-1] > j 
                    // Exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // for(int i = 0; i<n+1; i++){
        //     for(int j = 0; j<W+1; j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        System.out.println(unboundKP(val,wt,W));
    }
}
