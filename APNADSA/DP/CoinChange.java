package APNADSA.DP;

public class CoinChange {

    public static int CoinChangeofTarget(int coins[], int n, int tar){
        //1.Create Table
        int dp[][]  = new int[n+1][tar+1];
        
        //2. Intialization
        for(int i = 0 ; i<n+1; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i<dp[0].length; i++){
            dp[0][i] = 0;
        }

        // 3.Relation Logic
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<tar+1; j++){
                int coin = coins[i-1];
                if(coin <= j){
                    //1. Include 
                    int inc = dp[i][j-coin];
                    // 2.exclude
                    int exc = dp[i-1][j];
                    // total ways
                    dp[i][j] = inc + exc;
                }else{ // coin > j 
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][tar];
    }
    public static void main(String []args){
        int coins[] = {1,2,3};
        int n = coins.length;
        int tar = 4;
        System.out.print(CoinChangeofTarget(coins,n,tar));
    }
}
