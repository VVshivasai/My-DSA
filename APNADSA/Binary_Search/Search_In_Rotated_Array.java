package APNADSA.Binary_Search;

        /* 1.Find pivot in the array  [Time Complexity O(logN)]
         * 2.Decide Sesrch range by comparing taregt and maximum element
         * 3.Finally return the answer 
         */

import java.util.Scanner;

public class Search_In_Rotated_Array {
    public static void main(String[] args) {
        System.out.println();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        int target = in.nextInt();
        in.close();
        System.out.println(Serach(nums,target));
    }
     
  // decide search range by maximum element and return  answer to main method

    static int  Serach(int[] nums, int target) {
        int pivot = maxElement(nums);
        if(pivot >0 && nums[pivot]==target){
            return pivot;
        }
        if(pivot==-1){
            return BinarySearch(nums,0,nums.length-1,target);
        }
        if(nums[0]>target){
            return BinarySearch(nums, pivot+1,nums.length-1,target);
        }
        return BinarySearch(nums, 0,pivot-1,target);
    }

    // Searching for element in the array

    static int BinarySearch(int[] nums, int start, int end,int target) {  // O(logN)
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
          
        // search for maximum element in the array 

    static int maxElement(int[] nums) {              //O(LogN)
        int start =0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mid>start && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(nums[start]>=nums[mid]){
                end =mid-1;
            }else{
                start = mid+1;
            }
        }
        return-1;
    }

}
