package APNADSA.QueueS;

public class QueueWithArray {
    int arr[];
    int size;
    int rear;
    QueueWithArray(int n){
        this.arr = new int[n];
        this.size = n;
        this.rear = -1;
    }
    public  boolean isEmpty(){
        return rear == -1;
    }
    // Add operation 

    public void add(int data){
        if(rear == size-1){
            return;
        }
        rear = rear +1;
        arr[rear] = data;
    }

    // remove operation 

    public int remove(){
        if(isEmpty()){
            return -1;
        }
        int front = arr[0];
        for(int i =0;i<rear;i++){
            arr[i] = arr[i+1];
        }
        rear--;
        return front;
    }

    //peek operation

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[0];
    }

    //printing queue

    public void print(){
        while(rear != -1){
            System.out.println(this.peek());
            this.remove();
        }
    }

    public static void main(String args[]){
        QueueWithArray q = new QueueWithArray(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.print();
    }
}
