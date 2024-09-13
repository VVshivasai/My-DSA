package APNADSA.LinkedList;


public class LinkedList {

    public class Node{    // Node class is combination datatype and Reference(Address of its previous)
        int data;
        Node next;
        public Node(int data){  // Constructor of Node Class 
            this.data = data;
            this.next = null;
        }
    }
    public static Node Head;  // Start Node of Linked List
    public static Node Tail;  // End Node of Linked List
    public static int size;

    public void addAt_First(int data){
        // Step 1 --> Create a new Node of type Node
        Node newNode = new Node(data);
        size++;
        if(Head == null){
            Head = Tail = newNode;   // if Linked List is Empty 
            return ;
        }

        // If any elements are already present in Linked List
        // Step 2 --> Link the New Node's next to Head
        newNode.next = Head;

        // Change Head to newNode , to get Head to First element
        // step 3 --> change Head to its correct position 
        Head = newNode;
    }
    public void Add_at_Last(int data){
        
        // Step 1 --> Create a new Node of type Node
        Node newNode = new Node(data);
        size++;
        if(Head == null){
            Head = Tail = newNode;
            return;
        }
        
        // step 2 --> Link the New node reference(Next) to Tail 
        Tail.next = newNode;

        // step 3 --> Update Tail to last 
        Tail = newNode;


    }

    public void Add_At_Ith_Index(int idx,int data){

        //Step 1 --> Create a new Node with data 
        Node newNode = new Node(data);

        // check that Linked List is null or not
        if(idx==0){
            addAt_First(data);
            return;
        }
        size++;
        // step 2 --> Create a Node to track the Linked List and intially store Head(Start of LL)
        Node curr = Head;
        int i =0;
        while(i < idx-1){
            curr = curr.next;  
            i++;
        }
        Node temp = curr.next;   // store previous Node address(reference) ***think like swaap technique
        curr.next = newNode;     // Link newNode to Previous Node
        newNode.next = temp;    // link newNode to 

    }

    public int removeFirst(){
        if(size==0){    // size of Linked List is 0 means Null 
            return -1;
        }else if(size==1){  // only one element is there in the linked list 
            int val = Head.data;  // remove it 
            Head = Tail = null;   // meke head and tail to null
            size=0;  // size decrease to 0
            return val;
        }
        int val = Head.data;
        Head = Head.next;  // if linked list has more than one elements then remove head's data and 
        size--;           // Move head to next and decrease size by 1
        return val;
    }

    public int removeLast(){
        if(size==0 || size ==1){   // this case both Head and tail poitning towards samne 
            return removeFirst();
        }
        int val = Tail.data;
        Node prev = Head;
        for(int i = 0;i<size-2;i++){ // Take prev named node and travrse till second last node
            prev = prev.next;
        }
        Tail = prev;  // make Second last node as tail 
        prev.next = null; // make Second last node's next as null
        size--;  // decrease size by 1 
        return val;
    }
    public void Print_Linked_List(){

        Node curr = Head;   // Intially take Node name Curr to take every node's reference 
        while (curr != null){  // run while loop till curr not equal to null 
            System.out.print(curr.data +"-->"); 
            curr = curr.next;   
        }
        System.out.println("null");
    }

    public int Search_in_LinkedList(int target){ // linear search in linked list
        Node temp = Head;
        for(int i =0; temp!=null;i++ ){
            if(temp.data == target){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
    public int Helper(Node Head, int key){ // Linear Search in recursion
        if(Head == null){
            return -1;
        }
        if(Head.data == key){
            return 0;
        }
        int idx = Helper(Head.next,key);
        if(idx == -1){
            return idx;
        }
        return idx+1;
    }

    public int RecursiveSearch(int key){ // Linear Search in recursion
        return Helper(Head,key);
    }

   // revrse linked list 
    public void reverseLL(){
        Node prev = null;
        Node curr = Tail = Head;

        while(curr!=null){
            Node Front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Front;
        }
        Head = prev;

    }

    // Delete Nth node from End (Interview Question) -->1
    public void DeleteNthFromLast(int N){
        int size = 0; // first step find size of linked list
        Node temp = Head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        if(N==size){   // if N == size then definitely the element should be head because,
            Head = Head.next;  //the Question itself is that remove Nth from last
            return;
        }
        Node prev = Head;
        for(int i=0;i<size-N-1;i++){   // run the loop till size - N , here -1 is because i =0;
            prev = prev.next;
        }
        prev.next = prev.next.next;   // change Nth node's pehlewale(daani mundu node)Node's reference
        return;                       // to the Nth node's next node reference
    }
    /*
     * Find that given linked list is palindrome or not 
     * approach --> step 1 : Find mid of the node 
     *          --> step 2 : reverse the half of the linked list from the mid node 
     *          --> step 3 : take two pointer nodes left and right check the data utill any of the reaches
     *                       null which is pointing by mid  
     */
    private Node FindMid(Node Head){
        Node slow = Head;
        Node fast = Head;
        while(fast != null && fast.next != null){   // Even length and Odd length linked list 
            slow = slow.next; // +1 move
            fast = fast.next.next; // +2 move
        }
        return slow;
    }
    public boolean isPalindrome(){
        if(Head == null || Head.next == null){
            return true;
        }
        Node MidNode = FindMid(Head);
        // step 1 finished and step 2 starts
        Node prev = null;
        Node curr = MidNode;
        while(curr!=null){
            Node Front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Front;
        }
        // step 2 finished and step 3 starts 
        Node left = Head;
        Node right = prev;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String []args){
        LinkedList LL = new LinkedList();
        LL.addAt_First(2);
        LL.addAt_First(1);
        LL.Add_at_Last(3);
        LL.Add_at_Last(2);
        LL.Print_Linked_List();
        LL.Add_At_Ith_Index(0, 1);
        LL.Add_At_Ith_Index(2, 5);
        LL.Print_Linked_List();
        LL.removeFirst();
        LL.removeLast();
        LL.Print_Linked_List();
        System.out.println(size);
        System.out.println(LL.Search_in_LinkedList(1998));  // linear search in linked list
        System.out.println(LL.Search_in_LinkedList(10)); 
        System.out.println(LL.RecursiveSearch(1998)); // Search using Recursion
        System.out.println(LL.RecursiveSearch(10));
        LL.reverseLL();
        LL.Print_Linked_List();
        LL.Add_at_Last(1);
        LL.Print_Linked_List();
        LL.DeleteNthFromLast(3);
        LL.Print_Linked_List();
        System.out.println (LL.isPalindrome());
    }


    // Interview Question --> important

    /*
     * Step 1 --> Find mid of linked list 
     * Step 2 --> Reverse the second half of linked list
     * Step 3 --> Merge alternately (Like Zig Zag)
     */
    public void ZigZag() {
        // Step 1 :
        Node slow = Head;
        Node fast = Head.next;
        while(fast != null && fast.next != null){  
            slow = slow.next;
            fast = fast.next.next;
        }
        //Step 2:
        Node mid = slow;
        Node curr = mid.next;
        mid.next = null;
        Node prev =null;
        while(curr!=null){
            Node front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        // step 3
        Node leftHead = Head;
        Node rightHead = prev;
        Node right,left;
        while(leftHead != null && rightHead != null){
            left = leftHead.next;
            leftHead.next = rightHead;
            right = rightHead.next;
            rightHead.next = left;
            
            leftHead = left;    // move Left Head and right head to frontWards (towards null)
            rightHead = right;

        }
    }

}
