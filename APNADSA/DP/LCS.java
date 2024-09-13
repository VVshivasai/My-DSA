package APNADSA.DP;
import java.util.*;
public class LCS {


    // Recusion appraoch 
    public static int lcsRecursion(String str1, String str2, int n, int m){
        if(n==0 || m==0){
            return 0;
        }

        // case 1 : If Both equal
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return lcsRecursion(str1, str2, n-1, m-1) + 1;
        }
        else{ // Two choices, if they are not equal
            int longlcs1 = lcsRecursion(str1, str2, n-1, m);
            int longlcs2 = lcsRecursion(str1, str2, n, m-1);
            return Math.max(longlcs1,longlcs2);
        }
    }

    // Memoization --> O(n*m)
    public static int lcsMemoization(String str1, String str2, int n, int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }
        // case 1 : If Both equal
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m] = lcsRecursion(str1, str2, n-1, m-1) + 1;
        }
        else{ // Two choices, if they are not equal
            int longlcs1 = lcsRecursion(str1, str2, n-1, m);
            int longlcs2 = lcsRecursion(str1, str2, n, m-1);
            return dp[n][m] = Math.max(longlcs1,longlcs2);
        }
    }

    // Tabulation --> O(n*m)

    public static int lcsTabulation(String str1, String str2, int n, int m){
        //1. Create Table --> Variables are n,m
        int dp[][] = new int[n+1][m+1];

        //2. Intialization --> n = 0 then 0 or m = 0 then o
        // after intialization in java by default all are intilized by 0 

        // 3. Logic
        for(int i = 1; i<n+1; i++){ // i define str1's length
            for(int j = 1; j<m+1; j++){ // j define str2,s length
                if(str1.charAt(i-1) == str2.charAt(j-1)){ // both chars are equal and in having subsequence property
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else { // both are diff character then we have two choices either decrease str1 or str2
                    int ans1 = dp[i-1][j]; // decreasing str1
                    int ans2 = dp[i][j-1]; // decreasing str2
                    dp[i][j] = Math.max(ans1,ans2);
                }
            }
        }

        return dp[n][m]; // longest comman subsequence
    }
    // Tabulation --> O(n*m)
    public static int LongCmnSubStr(String str1, String str2,int n, int m ){
        int ans = 0; // Longest common substring
        // create Table by observing variable
        int dp[][] = new int[n+1][m+1];

        //2. Intialization --> n = 0 then 0 or m = 0 then o
        // after intialization in java by default all are intilized by 0 

        //3. logic (i,j) --> i is length of str1, j is length of str2
        for(int i =1; i<n+1;i++){
            for(int j =1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
            // Update longest common substring, it checks is there any largest substring after updating dp[i][j]
                    ans = Math.max(ans,dp[i][j]);
                }else{ // Both character are not eqaul, hence it is a substring then make dp[i][j] as 0
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str1 = "abedc";
        String str2 = "abc";

        System.out.println(lcsRecursion(str1,str2,str1.length(),str2.length())); // Recursion --> O(2^n)

        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int []arr : dp){
            Arrays.fill(arr,-1);
        }
        System.out.println(lcsMemoization(str1, str2, n, m, dp)); // Memoization --> O(n*m)

        System.out.println(lcsTabulation(str1,str2,n,m)); // Tabulation --> O(n*m)

        // Variation Longest common Subsequence
        System.out.println(LongCmnSubStr(str1, str2,n,m)); // longest common substring{variation of LCS}
    }
}
