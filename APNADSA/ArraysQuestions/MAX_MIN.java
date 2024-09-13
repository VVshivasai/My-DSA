package APNADSA.ArraysQuestions;

import java.util.Arrays;

public class MAX_MIN {
    static int find_SecondLargest(int []arr, int n){  // Finding Second Largest 
        int large  = Integer.MIN_VALUE;
        int sLarge = Integer.MIN_VALUE;
        for(int i =0;i < n;i++){
            if(arr[i]>large){
                sLarge = large;
                large = arr[i];
            }else if(arr[i]>sLarge && arr[i] != large){
                sLarge = arr[i];
            }
        }
        return sLarge;
    }
    static int find_SecondSmallest(int arr[], int n){ // Finding Second Smallest
        int small = Integer.MAX_VALUE;
        int sSmall = Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            if(arr[i]<small){
                sSmall = small;
                small = arr[i];
            }else if(arr[i] < sSmall && arr[i] != small){
                sSmall = arr[i];
            }
        }
        return sSmall;
    }
    static int[] Smax_Smin(int []arr, int n){
        int Second_Small = find_SecondSmallest(arr,n);
        int Second_Large = find_SecondLargest(arr,n);
        return new int[]{Second_Small,Second_Large};
    }
    public static void main(String[] args) {
        int arr[] = {2,3,7,1,4,8,9};
        int n = arr.length;
        System.out.println(Arrays.toString(Smax_Smin(arr,n)));
    }

}