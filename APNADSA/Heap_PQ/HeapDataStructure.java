package APNADSA.Heap_PQ;

import java.util.*;

public class HeapDataStructure {
    static class Heap{
        static ArrayList<Integer> heap = new ArrayList<>(); 

        public  void insert(int val){
            // step 1 : add at last 
            heap.add(val);   // adding O(1)
            int x = heap.size()-1;
            int par = (x-1)/2;
            //step 2 : fix heap
            while(heap.get(x) < heap.get(par)){  // for fixing (LogN)
                // swap
                int temp = heap.get(x);
                heap.set(x,heap.get(par));
                heap.set(par,temp);
                x = par; // child updation
                par = (x-1)/2; // update child and par index utill the heap be fixed.
            }
        }

        // Get Min in Heap : --> peek()
        public int peek(){
            return heap.get(0);
        }

        // remove element in the heap
        /*
         * Step 1 : --> Swap the Oth Node and Last Node 
         * Step 2 : --> remove the last node
         * Step 3 : --> Fix the heap by Heapify process
         *               | --> check the root with its left and right
         *               | --> swap them if they are in wrong order (call recursively untill fix the heap)
         */
        public void heapify(int i){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;
            // check left
            if(left < heap.size() && heap.get(minIdx) > heap.get(left)){
                minIdx = left;
            }
            // check right
            if(right < heap.size() && heap.get(minIdx) > heap.get(right)){
                minIdx = right;
            }

            //fix in their positions
            if(minIdx != i){
                // swap nodes
                int temp = heap.get(i);
                heap.set(i,heap.get(minIdx));
                heap.set(minIdx,temp);
                heapify(minIdx);
            }
        }

        public int remove(){
            // step 1 : --> swap the last and first node
            int temp = heap.get(0);
            heap.set(0,heap.get(heap.size()-1));
            heap.set(heap.size()-1,temp);
            // step 2 : --> remove the element 
            int data = heap.remove(heap.size()-1);
            // step 3 : fix the heap
            heapify(0);
            return data;
        }
        
        // check heap is empty or not
        public boolean isEmpty(){
            return heap.size() == 0;
        }
        // print method

        public void PrintHeap(){
            if(isEmpty()){
                System.out.println("Heap is empty");
                return;
            }
            while(!isEmpty()){
                System.out.print(peek()+" ");
                remove();
            }
        }
        public static void main(String args[]){
            Heap Obj = new Heap();
            Obj.insert(4);
            Obj.insert(1);
            Obj.insert(0);
            Obj.insert(-1);
            Obj.PrintHeap();
        }
    }
}
