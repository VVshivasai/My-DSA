package APNADSA.StackS;

import java.util.*;

/*
 * Brute Force Approach ---> O(N^2) time Complexity
 * Optimal Approach Using Stack --> O(N)
 */

public class NextGreaterElm {

    public static int[] NextGreat(int nums[]){
        int []ans =new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i =nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = nums[st.peek()];
            }
            st.push(i);
        }
        return ans;
    }
    public static void main(String args[]){
        int nums[] = {7,0,2,8,6,4,3,5,2,1};
        System.out.println(Arrays.toString(NextGreat(nums)));
    }
}
