package APNADSA.Auxillary_ArraysTopic;

import java.util.Scanner;

public class TrappingRain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int height[] = new int[n];
        for(int i=0;i<n;i++){
            height[i] = in.nextInt();
        }
        in.close();
        System.out.println(MaxTrappedWater(height,n));
    }

    static int MaxTrappedWater(int[] height, int n) {
        int tp =0; //trapped water
        if(n==1||n==2){
            return tp;
        }
        
        // creating two auxillary arrays for finding boundaries 

        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        // finding left side boundary to store water


        leftMax[0] = height[0];
        for(int i=1;i<n;i++){
            if(height[i]>leftMax[i-1]){
                leftMax[i]=height[i];
            }else{
                leftMax[i]=leftMax[i-1];
            }
        }

        // finding right side boundary to store water

        rightMax[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            if(height[i]>rightMax[i+1]){
                rightMax[i]=height[i];
            }else{
                rightMax[i]=rightMax[i+1];
            }
        }

        // finding trapped water

        for(int i=0;i<n;i++){
            tp+=(Math.min(leftMax[i],rightMax[i])-height[i]); // take min of both boundaries 
        }
        return tp;  
    }

}
