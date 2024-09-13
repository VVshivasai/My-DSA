package APNADSA.Heap_PQ;

public class HeapSortASC {
    /*
     * Sort in Ascending Order :--> Time Complexity O(n*logn)
     *                          --> Create Max Heap 
     *                          --> take the first element in the heap swap it 
     *                              with last element in the array 
     *                          
     */
    public static void heapify(int []arr, int i, int n){
        int left = 2*i +1;
        int right = 2*i +2;
        int maxIdx = i;
        if(left < n && arr[left]>arr[maxIdx]){
            maxIdx = left;
        }
        if(right < n && arr[right]>arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            // swap 
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, n);
        }

    }

    public static void Heapsort(int arr[]){
        int n = arr.length;
        // step 1 : --> Build max heap
        for(int i = n/2; i>=0; i--){
            heapify(arr,i,n);
        }

        // step 2 : --> push largest element to end 
        for(int i = n-1; i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void main(String args[]){
        int arr[] ={2,1,4,3,7,5};
        Heapsort(arr);
        for(int i = 0 ; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
