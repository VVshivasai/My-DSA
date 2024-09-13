package APNADSA.SortingS;

import java.util.Arrays;
import java.util.Scanner;

public class Bubble_Sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        in.close();
       // BubbleSort(arr);
        BubbleSort(arr, n-1, 0);
       // System.out.print(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr));

    }

    static void BubbleSort(int arr[],int row,int col){
        if(row ==0){
            return;
        }
        if(col<row){
            if(arr[col]>arr[col+1]){
                // swap
                int temp = arr[col];
                arr[col] = arr[col+1];
                arr[col+1] = temp;
            }
            BubbleSort(arr,row,col+1);
        }else{
            BubbleSort(arr,row-1,0);
        }

    }
    // sort in decreasing order
    static void BubbleSort(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int swap =0;                          //for Best Case O(N)
            for(int j=0;j<n-i-1;j++){
                if(arr[j]<arr[j+1]){  
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]= temp;
                    swap++;
                }
            }
            if(swap==0){
                break;
            }
        }
    }
}
