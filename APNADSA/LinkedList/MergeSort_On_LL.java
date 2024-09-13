package APNADSA.LinkedList;

/* Merge Sort: Time Complexity --> O(N*LogN)
 * Pre Requisite : Merge Sort on Arrays and recursion
 * Step 1 : Write a method to find Middle of Linekd List By (slow - fast pointer approach)
 * Step 2 : write Recursive function for divide the Linked list util the the list becomes smaller 
 *          as like we did in the arrays (Single element)
 * Step 3 : write a function to merge the sorted elements
 */

public class MergeSort_On_LL {
    public static void main(String []args){
        LinkedList list = new LinkedList();
        list.addAt_First(5);
        list.addAt_First(4);
        list.addAt_First(0);
        list.addAt_First(2);
        list.addAt_First(1);
        // before sort
        System.out.println(list);
        // after sort 
        System.out.println(list);
    }


}
