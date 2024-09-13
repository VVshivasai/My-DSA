package APNADSA.Heap_PQ;

import java.util.*;

public class SlidingWindowMax {
    /*Sliding window Maximum 
     * Time Complexity --> O(N*LogN)
     * Space Complexity --> O(N)
     */

    static class MaxElement implements Comparable<MaxElement>{

        int max;
        int idx;
        MaxElement(int max, int idx){
            this.idx = idx;
            this.max = max;
        }

        @Override
        public int compareTo(MaxElement prevObj){
            return prevObj.max - this.max; // sort in descending (Max Heap)
        }
    }

    public static int[] SlidingWindow(int arr[], int k){
        int n = arr.length;
        int []window = new int[n-k+1];
        PriorityQueue<MaxElement> pq = new PriorityQueue<>();
        // add first window (First K elements)
        for(int i = 0 ; i < k; i++){
            pq.add(new MaxElement(arr[i], i));
        }
        window[0] = pq.peek().max;
        for(int i = k ; i<n; i++){
            while(pq.size() > 0 && pq.peek().idx <= i-k){
                pq.remove();
            }
            pq.add(new MaxElement(arr[i], i));
            window[i-k+1] = pq.peek().max;
        }
        return window;
    }
    public static void main(String args[]){
        int arr[] = {3,4,1,0,2,5,3};
        int k = 3;
        System.out.println(Arrays.toString(SlidingWindow(arr,k)));
    }
}
