package APNADSA.StackS;
import java.util.*;
/*
 * Microsoft and google
 * if Any duplicate paranthesis "()" is there return true otherwise return false 
 * Time Complexity O(N) && Space Complexity O(N)
 * Algorithm :
 * Step 1--> create a stack of character
 * step 2--> run a for loop upto string length
 * step 3--> check whether the character is ')' closing paranthesis, if is then 
 *           take  count =0;
 *           check for opening paranthesis '(' in the stack 
 *           if the count < 1 then the there is no other elements it the in between () which makes true
 * step 4--> push character in the stack if character is not equal to closing paranthesis ')'
 * step 5--> return false --> there is no duplicate() in the string 
 */

public class isDuplicateParanthesis {
    public static boolean isDuplicatePar(String str){
        Stack<Character> st = new Stack<>();
        for(char c : str.toCharArray()){
            if(c ==')'){
                int count =0;
                while(st.pop() != '('){
                    count ++;
                }
                if(count<1){
                    return true;
                }
            }else{
                st.push(c);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((a+b)+(c+d))";
        String str1 = "((a+b))";
        System.out.println(isDuplicatePar(str));
        System.out.println(isDuplicatePar(str1));
    }
}
