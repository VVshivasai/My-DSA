package  DSAKUNAL.Linear_Search;

import java.util.Scanner;

class LinearSearch {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        in.close();
        LinearSearch obj = new LinearSearch();
        boolean ans = obj.Search(arr,target);
        System.out.println(ans);
    }

    boolean Search(int[] arr, int target) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return true;
            }
        }
        return false;
    }

}
