package APNADSA.ArraysPractice;
    /* 1. Brute Force Approach O(n^3) 
          Using Three loops by Loop inside a loop


       2. Optimal by Prefix Sum O(n^2)
          By creating an new array 


       3. Kadane'S algorithm   O(n)

        find max sum in sub arrays
    */
public class MaxSumOFSubArray {
    public static void main(String[] args) {
        int[] array = {-2,-1,-2,0};

        BruteForce(array);       //O(n^3)
    
        Optimal(array);        // O(n^2)
                               
        Better(array);       // O(n)
                
    }

     //O(N) Kadane's algo 


    static void Better(int[] array) {                  /* Kadane's algo which neglects the negative sum values
                                                            compare positive maximum values    
                                                        */
        int CurrSum=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){       //  case : if array contains all negative elements 
            if(array[i]>max){
                max=array[i];
            }
        }
        if(max<=0){
            System.out.println(max);
            return;
        }
        for(int i=0;i<array.length;i++){
            CurrSum +=array[i];
            if(CurrSum<0){
                CurrSum=0;
            }
            max = Math.max(CurrSum,max);
        }
        System.out.println(max);
    }



        // O(N^2)  Prefix Sum


    static void Optimal(int[] array) {
        int n = array.length;
        int max= Integer.MIN_VALUE;
        int Prefix[] = new int[n];  // creating an array named prefix sum 
        Prefix[0] = array[0];
        for(int i=1;i<n;i++){
            Prefix[i] = Prefix[i-1]+array[i];
        }

        for(int i=0;i<n;i++){           // finding max of subarray
            int CurrSum=0;                  // i th Sum 
            for(int j=i;j<n;j++){
                CurrSum = (i==0)?Prefix[j]:Prefix[j]-Prefix[i-1];
                if(CurrSum>max){  
                    max=CurrSum;
                }
            }
        }

        System.out.println(max);
    }



   // Brute Force Approach





    static void  BruteForce(int[] array){
        int n = array.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum +=array[k];
                    if(sum<min){
                        min=sum;
                    }if(sum>max){
                        max=sum;
                    }
                }
            }
        }
        System.out.println(min+"  "+max); // min ,max of subarrays 
    }

}
