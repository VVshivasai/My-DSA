package APNADSA.Hashing;

import java.util.*;
public class LargestSubArraySum {
    public  static int  FindLargeSubArrayEqualsto0(int[] nums) {
        int max = 0;
        int n = nums.length;
        // Brute force O(N^2)
        for(int i = 0; i<n; i++){
            int sum = 0;
            for(int j = i; j<n; j++){
                sum += nums[j];
                if(sum == 0){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
    /* 
     *  Time Complexity --> O(N)
     *  Space Complexity --> O(N)
     */
    public static int FindMaxLen(int []nums){
        int len = 0;
        int sum = 0;
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            if(sum == 0){
                len = i+1;
            }
            else if(map.containsKey(sum)){
                len = Math.max(len, i - map.get(sum));  // j = map.get(sum)
            }else{
                map.put(sum,i);
            }
        }
        return len;
    }
    
    public static void main(String args[]){
        int nums[] = {-5,5,2,-2};

        System.out.println(FindLargeSubArrayEqualsto0(nums));// O(N*N)
        System.out.println(FindMaxLen(nums));//O(N)
    }

}
