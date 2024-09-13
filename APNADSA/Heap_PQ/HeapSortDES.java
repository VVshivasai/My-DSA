package APNADSA.Heap_PQ;

public class HeapSortDES {

    public static void heapify(int arr[],int i,int n){
        int left = 2*i +1;
        int right = 2*i +2;
        int minIdx = i;
        // check that is there any min in left
        if(left < n && arr[left]<arr[minIdx]){
            minIdx = left;
        }
        if(right < n && arr[right]<arr[minIdx]){
            minIdx = right;
        }
        if(minIdx != i){
            //swap 
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
            heapify(arr, minIdx, n);
        }
    }

    // push smallest elem to last 

    public static void HeapsortDes(int arr[]){
        int n = arr.length;
        // Step 1 : --> Build min heap
        for(int i = n/2; i>=0; i--){
            heapify(arr, i, n);
        }
        // step 2 : --> push smallest elem to last of array (Thought intuitively i.e, observe min heap properties)
        for(int i = n-1; i>0;i--){
            //swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }

    }
    public static void main(String args[]){

        int arr[] = {3,6,1,0,2,5};
        HeapsortDes(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
