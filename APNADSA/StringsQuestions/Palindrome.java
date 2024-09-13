package APNADSA.StringsQuestions;

import java.util.*;


public class Palindrome {

    static boolean isPalindrome(String sr){
        int n = sr.length();
        for(int i=0;i<n/2;i++){
            if(sr.charAt(i)!=sr.charAt(n-1-i)){          // Palindrome check for String By Two Pointer Approach
                return false;                              // Time Complexity O(N/2)
            }                                               // Space Complexity O(1)
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println();
        String str = in.nextLine();
        in.close();
        System.out.println(isPalindrome(str));
    }
}
