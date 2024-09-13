package APNADSA.StackS;
/*
 * interview question 
 * push the given element at bottom of stack
 * 
 * 
 * 
 * APPROACH -->1  T.C --> O(N), S.C--> O(N)
 * 1.take another data structure 
 * 2. pop every element from stack and store it in data structure like arrays, arrayList ..
 * 3.push the given element into stack 
 * 4.add elements from data structure to stack 
 * 
 * 
 * 
 * APPROACH -->2 T.C --> O(N), S.C --> O(1)
 * using Recursion and Backtrack 
 * BASE CASE: --> call the function still stack would be empty
 * WORK: --> Store the top element and call the function for next element (POP the element)
 * Back track: --> add the elements into stack (PUSH the eleement)
 */
import java.util.*;
public class PushAtBottom {
    public  static void PushBottom(Stack<Integer> s, int val){
        if(s.isEmpty()){
            s.push(val);
            return;
        }
        int top = s.pop();
        PushBottom(s, val);
        s.push(top);
    }
    public static void main(String []args){
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(3);
        s.push(1);
        PushBottom(s, 4);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

}
