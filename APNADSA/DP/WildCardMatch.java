package APNADSA.DP;

public class WildCardMatch { // slight Variation of LCS

    // Tabulation --> O(n*m)
    
    public static boolean IsMatch(String s, String p){
        int n = s.length();
        int m = p.length();
        // Create Table of n,m
        boolean dp[][] = new boolean[n+1][m+1];

        // Intialization or Base Case

        //1. (0,0) is always matches so (0,0) --> true
        dp[0][0] = true;
        //2. s = " " which means i = 0 ,  whatever j gives there *  to match which gives sequence or empty meaning also
        for(int j = 1; j<m+1; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        //3. p = " " -->then there is no string in  p to match
        for(int i = 1; i<n+1; i++){
            dp[i][0] = false;
        } 

        // Meaning and relation (small to large) solution
        for(int i = 1; i<n+1; i++){
            for( int j = 1; j<m+1; j++){
                //1.case --> both char are equal || char at jth is '?'
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                //2. case --> char at jth is '*' then two choices hold it for sequence or ignore it for empty 
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                //3. case -->both char are diffrent  gives always false
                else{
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String s = "abcabczzzde" ;
        String p = "*abc???de*" ;
        System.out.println();
        System.out.println(IsMatch(s,p)); // O/p --> True
    }
}
