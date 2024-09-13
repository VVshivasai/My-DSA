
package APNADSA.SortingS;

import java.util.*;                      // Time complexity O(N+Frequency)
                                         // Best case O(N) if frequency of each element is 1
import java.util.Scanner;
/*
 * 1. First find the largest element in the array 
 * 2. create an array named count of length is equal to largest+1
 * 3. count the frequency of elements in the array and store them in count array
 * 4. sort them by them by traverse count array
 */
public class CountSort {
    public static void main(String[] args) {       
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        in.close();
        Count_Sort(arr,n);
        System.out.println(Arrays.toString(arr));
    }
    static void Count_Sort(int arr[], int n){
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            largest = Math.max(largest,arr[i]);
        }
        // create an array which is of length largest + 1
        int count[] = new int[largest+1];
        for(int i=0;i<n;i++){
            count[arr[i]]++; // frequency of elements in the array  
        }
        // sorting the elements in decreasing order . Here Traverse Count array
        int j=0;
        for(int i=count.length-1;i>=0;i--){    //O(N)
            while(count[i]>0){              //O(Count[i]) which is equal to frequency of element i.e; O(Frequency)
                arr[j] = i;  
                count[i]--;
                j++;
            }
        }
    }
}
 