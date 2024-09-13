package DSAKUNAL.Binary_Search;

import java.util.Scanner;

public class LeetCode33 {
    public static void main(String[] args) {    //https://leetcode.com/problems/search-in-rotated-sorted-array/
        Scanner in = new Scanner(System.in);    // asked in FAANG (Search in Rotated Sorted array )
        int n = in.nextInt();
        int []nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        int target = in.nextInt();
        in.close();
        System.out.println(search(nums,target));

    }
    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(pivot == -1){   // simple binary search
            return BinarySearch(nums, target, 0, nums.length-1);
        }
        if(nums[pivot]==target){
            return pivot;
        }else if(nums[0]>target){
           return BinarySearch(nums, target,pivot+1 ,nums.length-1);
        }else {
            return BinarySearch(nums, target, 0, pivot-1);
        }
    } 
    static int BinarySearch(int[] nums, int target, int start, int end){
        while(start<=end){
            int mid = start + (end-start)/2;
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
    static int findPivot(int[] nums){
        int start =0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start +(end -start)/2;
            if(mid <end && nums[mid]>nums[mid+1] ){
                return mid;
            }
            if(start<mid && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(nums[start]>=nums[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }     
}
