package APNADSA.QueueS;

import java.util.Stack;

public class QueueUsingStack {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public static boolean isEmpty(){
        return s1.isEmpty();
    }

    // add element
    public void add(int data){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(data);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    // remove operation

    public int remove(){
        if(s1.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return s1.pop();
    }

    //peek operation 

    public int peek(){
        if(s1.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return s1.peek();
    }
    // print method
    public void print(){
        if(s1.isEmpty()){
            System.out.println("queue is Empty");
        }
        while(!s1.isEmpty()){
            System.out.println(s1.peek());
            s1.pop();
        }
    }

    public static void main(String []args){
        QueueUsingStack q = new QueueUsingStack();
        q.add(1);
        q.add(3);
        q.add(4);
        q.print();
    }
}
