package APNADSA.DoubleLinkedList;

public class DoubleLinkedList {
    public class Node{    /*Creation of Node which consists  1--> Data  2--> next  3--> prev */
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;


    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        newNode.next = null;
    }


    public void removeFirst(){
        if(size == 0){
            return;
        }else if(size==1){
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeLast(){
        if(size ==0){
            return;
        }else if(size==1){
            head = tail = null ;
            size-- ;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
        
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data +"<--->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        DoubleLinkedList DLL = new DoubleLinkedList();
        DLL.addFirst(3);
        DLL.addFirst(2);
        DLL.addFirst(1);
        DLL.addLast(4);
        DLL.addFirst(5);
        System.out.println(size);
        DLL.print();
        DLL.removeFirst();
        System.out.println(size);
        DLL.removeLast();
        DLL.print();
    }
}
