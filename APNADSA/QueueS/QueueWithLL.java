package APNADSA.QueueS;

public class QueueWithLL {
    public class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    static ListNode head;
    static ListNode tail;

    public static boolean isEmpty(){
        return head==null && tail==null;
    }
        
    // adding element 
    public void add(int data){
    ListNode newNode = new ListNode(data);
    if(isEmpty()){
        head = tail = newNode;
        return;
    }
    tail.next = newNode;
    tail = newNode;
    }

    // remove element
    public int remove(){
        if(isEmpty()){
            return -1;
        }
        int front = head.data;
        if(tail == head){
            head = tail = null;
            return front;
        }
        head = head.next;
        return front;
    }

    // peek operation
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return head.data;
    }

    // print queue
    public void print(){    
        while(!isEmpty()){
            System.out.println(this.peek());
            this.remove();
        }
    }   

    public static void main(String args[]){
            QueueWithLL q = new QueueWithLL();
            q.add(0);
            q.add(1);
            q.add(3);
            q.print();
    }
}


