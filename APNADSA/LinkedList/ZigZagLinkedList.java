package APNADSA.LinkedList;

public class ZigZagLinkedList {
    public static void main(String []args){
        LinkedList LL = new LinkedList();
        LL.addAt_First(1);
        LL.Add_at_Last(2);
        LL.Add_at_Last(3);
        LL.Add_at_Last(4);
        LL.Add_at_Last(5);
        LL.Print_Linked_List();
        LL.ZigZag();
        LL.Print_Linked_List();
    }
}
