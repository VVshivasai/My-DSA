package APNADSA.StackS;
// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
/*
 * Microsoft , Gooogle FaceBook (Important)
 * 
 * Approach --> Time Complexity O(N)
 *          --> Space O(N)
 * // Method 1
 * step 1 : find next smallest element's index in the right (j) for every element in the array 
 * 
 * 
 * // Method 2
 * step 2 : find next samllest element's index in the left (i) for every element in the array
 * 
 * 
 * // Method for MAX AREA of HISTOGRAM
 * step 3 : run a for loop form i = 0 to N
 *          find area -->  area = heigth[i] * (j - i - 1);
 * step 4 : compare it with maxArea --> Math.max(area,maxArea);
 * step 5 : return maxArea
 */

import java.util.Stack;

public class MaxHistogram {

    public static int[] nextSmallestRight(int heights[],int n){  // step 1 
        int nsr[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }if(st.isEmpty()){
                nsr[i] = n;
            }else{
                nsr[i] = st.peek();
            }
            st.push(i);
        }
        return nsr;
    }

    public static int[] nextSmallestLeft(int heights[], int n){ // step 2
        int nsl[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }if(st.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = st.peek();
            }
            st.push(i);
        }
        return nsl;
    }
    

    public static int maxHistogram(int heights[], int n){ // step 3 which returns required output 
        int maxArea = 0;
        int nsr[] = nextSmallestRight(heights, n);
        int nsl[] = nextSmallestLeft(heights, n);
        for(int i =0;i<n;i++){
            int height = heights[i];
            int widht = nsr[i] - nsl[i] -1;
            int area = height * widht;
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        int n = heights.length;
        System.out.println(maxHistogram(heights,n));
    }
}
