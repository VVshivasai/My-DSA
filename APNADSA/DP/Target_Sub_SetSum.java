package APNADSA.DP;
// Variation of 0-1 knapsack
public class Target_Sub_SetSum {

    static boolean Tabulation(int nums[], int tar){
        int n = nums.length;
        // 1. Create Table
        boolean dp[][] = new boolean[n+1][tar+1];

        // 2. Intialisation 
        for(int i = 0; i<n+1; i++){
            dp[i][0] = true;
        }

        // Relation and logic
        for(int i = 1; i<n+1; i++){
            for(int j= 1; j<tar+1; j++){
                int v = nums[i-1];
                // if Include v then it makes subset sum valid for j 
                if(v<=j && dp[i-1][j-v]){
                    dp[i][j] = true;
                }
                // If exclude v then it makes subset sum valid for j
                else if(dp[i-1][j]){
                    dp[i][j] = true;
                }
                // v>j its always false there is only one choice that is exclude
            }
        }

        return dp[n][tar];
    }
    public static void main(String[] args) {
        int nums[] = {4,2,7,1,3};
        int target = 3;
        System.out.println(Tabulation(nums,target));
    }
}
