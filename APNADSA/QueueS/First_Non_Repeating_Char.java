package APNADSA.QueueS;

import java.util.*;

public class First_Non_Repeating_Char {


    /*
     * FlipKart Question
     * 
     * Time Complexity -->O(N)
     * 
     * Space Complexity -->O(N)
     * 
     */

    public static char[] First_Non_Repeating(String s){
        int n = s.length();
        char ans[] = new char[n];
        Queue<Character> q = new LinkedList<>();
        char freq[] = new char[26];
        for(int i =0; i<n; i++){
            char ch = s.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.poll();
            }
            if(q.isEmpty()){
                ans[i] = (char)-1;
            }else{
                ans[i] = q.peek();
            }

        }
        return ans;
    }
    public static void main (String args[]){
        String s = "aabccxb";
        System.out.println(Arrays.toString(First_Non_Repeating(s)));
    }
}
