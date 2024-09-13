package APNADSA.DP;
/*Variation of 0-1 KP --> Bottom UP Manner (Tabulation)
 * Every elem have Two Choices 1. want to contribute to sum1 means Set1
 * or 2. Contribute to sum2 means Set2
 */
public class MIN_PARTITION {


    private static int _O_1_KP(int[] nums, int[][] dp, int n, int W) {
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<W+1; j++){
                int val = nums[i-1];
                int wt = nums[i-1];
                if(wt<=j){ // Inlcude or Exclude
                    dp[i][j] = Math.max(val + dp[i-1][j-wt],dp[i-1][j]);
                }else{ // wt > cap so Directly Exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W]; // sum1 

    }

    static int minPartition(int nums[], int n){
        // Step1 : Find sum of All elems
        int sum = 0;
        for(int i : nums){
            sum  += i;
        }
        int W = sum/2; // Capacity of 0-1 KP which means bag1 == set1 return sum1
        //Created table with VAriables
        int dp[][] = new int[n+1][W+1];

        int sum1 = _O_1_KP(nums,dp,n,W); // set1 sum
        int sum2 = sum - sum1; // set2 sum
        return Math.abs(sum1 - sum2);

    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        int n = nums.length;

        System.out.println(minPartition(nums, n));
    }
}
