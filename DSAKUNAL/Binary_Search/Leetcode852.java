package DSAKUNAL.Binary_Search;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

import java.util.Scanner;

public class Leetcode852 {
     public static void main(String[] args) {    // 2. Interview Question (BINARY SEARCH)
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        in.close();
        Leetcode852 obj = new Leetcode852();
        System.out.print(obj.PeakElement(nums));
    }

    public int PeakElement(int[] nums) {
        int start =0,end = nums.length-1;
        while(start<end){
            int mid = start +(end -start)/2;
            if(nums[mid]>nums[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}
