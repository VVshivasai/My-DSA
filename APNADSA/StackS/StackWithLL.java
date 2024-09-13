package APNADSA.StackS;

/*
 * Stack using Linked List 
 * PUSH Operation --> create a new Node , point the new Node,s Next to head.
 * make new Node as Head.
 * 
 * POP operation --> store the value in top variable 
 * make head to head.next
 * 
 *PEEK operation --> take the value from stack (head.val) and return it to print Function 
 */

public class StackWithLL {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public class Stack{
        public static ListNode head=null;
        static boolean  isEmpty(){
            return head==null;
        }

        // push operation --> O(1)
        public void push(int val){
            ListNode newNode = new ListNode(val);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // pop operation --> O(1)
        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.val;
            head = head.next;
            return top;
        }

        //peek operation --> O(1)
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.val;
        }
        // print stack --> O(N)
        public void Print(){
            if(isEmpty()){
                System.out.print("Stack is Empty");
            }
            while(!isEmpty()){
                System.out.println(this.peek());
                this.pop();
            }
        }
        public static void main(String []args){
            StackWithLL STLL = new StackWithLL();
            Stack st = STLL.new Stack();
            st.push(1);
            st.push(2);
            st.push(3);
            st.Print();
        }
    }
}
