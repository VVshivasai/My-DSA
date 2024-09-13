package APNADSA.StackS;

import java.util.*;;

public class StackUsingQueue {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public static boolean isEmpty(){
        return (q1.isEmpty() && q2.isEmpty());
    }

    // push Operation -->O(N)
    public void push(int data){
        if(!q1.isEmpty()){
            q1.add(data);
        }else{
            q2.add(data);
        }
    }

    // pop operation -->O(N)
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int top =-1;
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.poll();
                if(q1.isEmpty()){
                    break;
                }
                q2.add(top);
            }
        }else{
            while(!q2.isEmpty()){
                top = q2.poll();
                if(q2.isEmpty()){
                    break;
                }
                q1.add(top);
            }
        }
        return top;
    }

    // peek operation -->O(N)
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        int top =-1;
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.poll();
                q2.add(top);
            }
        }else{
            while(!q2.isEmpty()){
                top = q2.poll();
                q1.add(top);
            }
        }
        return top;
    }

    // print stack method

    public void print(){
        while(!isEmpty()){
            System.out.println(this.peek());
            this.pop();
        }
    }

    // main method 

    public static void main(String args[]){
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();
    }
}
