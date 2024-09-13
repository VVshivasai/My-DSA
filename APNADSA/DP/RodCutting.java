package APNADSA.DP;

public class RodCutting {

    //Tabulation --> O(price.length * rodLength)
    private static int GetMaxProfit(int len[],int price[],int rodLength){
        int n = price.length;
        //Create table of 2d array
        int dp[][] = new int[n+1][rodLength+1];
        // Intial condition Or Base case in Memoization
        for(int i = 0; i<n+1; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i<dp[0].length; i++){
            dp[0][i] = 0;
        }

        // Relation for each cell (i,j)
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<rodLength+1; j++){
                int capableCut = len[i-1];
                if(capableCut <= j){
                    // Two choices include and exclude
                    int inc = price[i-1] + dp[i][j-capableCut];
                    int exc = dp[i-1][j];
                    dp[i][j] = Math.max(inc,exc);
                } else{ // not a valid cut
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rodLength];
    }
    public static void main(String[] args) {
        int length[] = {2,3,4};
        int price[] = {4,5,6};
        int rodLength = 6;
        System.out.println(GetMaxProfit(length,price,rodLength));
    }
}
