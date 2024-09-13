package APNADSA.StackS;
import java.util.*;
public class Stacks {
    public class Stack{
        static ArrayList<Integer> list = new ArrayList<>(); // stacks using arrayList
        static int size = 0;
        public static boolean isEmpty(){
            return list.size()==0;
        }
        /*
         * stacks are having three operations 1 --> push means add
         *                                    2 --> pop means remove;
         *                                    3 --> peek means see the element from top 
         */


         // push function
        public void push(int data){
            list.add(data);
            size++;
            return;
        }


        // pop function
        public int pop(){
            if(isEmpty()){  // list.size == 0
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            size--;
            return top;
        }

        // peek function 
        public int peek(){
            if(isEmpty()){
                return Integer.MIN_VALUE;
            }
            return list.get(list.size()-1);
        }

        // printing elements in the stack and removing it after printing
        public void printStack(){
            while(!isEmpty()){
                System.out.println(this.peek());
                this.pop();
            }
        }

        public static void main(String []args){
            Stacks stOut = new Stacks();  // main class instance 
            Stack st = stOut.new Stack(); // inner class instance by using outer class 
            st.push(1);
            st.push(2);
            st.push(3);
            st.push(4);
            st.push(5);
            st.push(6);
            System.out.println(size);
            st.printStack();
        }
    
    }

}