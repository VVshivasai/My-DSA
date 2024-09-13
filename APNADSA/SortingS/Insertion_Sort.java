package APNADSA.SortingS;
/*
 * 1. Take first element in the array
 * 2. Store it in the (curr) named variable 
 * 3. place it in its correct position by back Tracking technique 
 * 4. Simply check all the previous elements until finding its correct position 
 */
import java.util.*;
public class Insertion_Sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        in.close();
        InsertionSort(arr,n);
        System.out.println(Arrays.toString(arr));
    }
    public static void InsertionSort(int []arr,int n){
        for(int i=1;i<n;i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev>=0 && curr > arr[prev]){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }

}
