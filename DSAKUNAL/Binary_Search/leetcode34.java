package DSAKUNAL.Binary_Search;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

import java.util.Arrays;
import java.util.Scanner;

public class leetcode34 {
    public static void main(String[] args) {    // 1. FACEBOOK INTERVIEW QUESTION (BINARY SEARCH)
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        int target = in.nextInt();
        in.close();
        leetcode34 obj = new leetcode34();
        int ans[] = obj.searchRange(nums, target);
        //System.out.print(ans[0]+"  "+ans[1]);
        System.out.println(Arrays.toString(ans));

    }
    public int[] searchRange(int[] nums, int target) {
            int ans[] = {-1,-1};
            int start = Search(nums,target,true);
            int end =  Search(nums,target,false);
            ans[0] =start;
            ans[1] = end;
            return ans;
    }
    static int Search(int[] nums, int target, boolean findIndex){

        int ans=-1;
        int start =0,end = nums.length-1;
        while(start<=end){


            int mid = start +(end -start)/2;
            if(nums[mid]>target){
                end = mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                ans =mid;
                if(findIndex){
                    end =mid-1;
                }else{
                    start = mid+1;
                }
            }
        }
        return ans;
    }
}

