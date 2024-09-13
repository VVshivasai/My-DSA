package DSAKUNAL.Binary_Search;

import java.util.Scanner;

class BinarySearch {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        in.close();
        BinarySearch obj = new BinarySearch();
        boolean ans = obj.Search(arr,target);
        System.out.println(ans);
    }

    boolean Search(int[] arr, int target) {
       int Start =0;
       int End = arr.length-1;
       boolean isAscending = (arr[Start]<arr[End]);
       while(Start<=End){
            int mid = Start +(End -Start)/2;
            if(isAscending){
                if(arr[mid]==target){
                    return true;
                }else if(arr[mid]<target){
                    Start = mid+1;
                }else{
                    End = mid-1;
                }
            }else{
                if(arr[mid]==target){
                    return true;
                }else if(arr[mid]>target){
                    Start = mid+1;
                }else{
                    End = mid-1;
                }
            }
        }
        return false;
    }
}