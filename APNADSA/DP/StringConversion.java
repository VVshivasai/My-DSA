package APNADSA.DP;
import java.util.*;
/* Variation of LCS 
 * Converting String1 to String2 by using del and insert operations
*/
public class StringConversion {
    // Memoization technique Time Complexity O(n*m)
    private static int LCS(String str1, String str2, int dp[][], int n, int m){
        if(n == 0 || m == 0 ){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m] = LCS(str1, str2, dp, n-1, m-1) + 1;
        }else{
            int longest1 = LCS(str1, str2, dp, n-1, m);
            int longest2 = LCS(str1, str2, dp, n, m-1);
            return dp[n][m] = Math.max(longest1,longest2);
        }
    }

    public static int Conver1To2(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int [n+1][m+1];
        for(int arr[]: dp){
            Arrays.fill(arr,-1);
        }
        int lcs = LCS(str1,str2,dp,n,m);
        int deleteOperations = n - lcs;
        int addOperations = m - lcs;
        return deleteOperations + addOperations;
    }
    public static void main(String args[]){
        String str1 = "abcdef";
        String str2 = "abcg";
        System.out.println(Conver1To2(str1,str2));
    }

}
