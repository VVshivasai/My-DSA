package DSAKUNAL.Selection_Sort;
import java.util.Arrays;
/*Approach 
    1.Find LastINdex
    2.find MaxNumber Contained Index                Time Complexity Both Best And Wrost O(N^2)
    3. Swap both numbers
 */
import java.util.Scanner;
public class SelctionSort {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n = in.nextInt();
        int array[] = new int[n];
        for(int i=0;i<n;i++){
            array[i]=in.nextInt();
        }
        in.close();
        selectionSort(array,n);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array, int n) {
        for(int i=0;i<n;i++){
            int last=n-i-1;
            int maxINdex = getMaxIndex(array,0,last);
            swap(array,maxINdex,last);
        }  
    }
    static void swap(int[] array, int maxINdex, int last) {
        int temp = array[maxINdex];
        array[maxINdex]=array[last];
        array[last]=temp;
    }

    static int getMaxIndex(int[] array, int i, int last) {
        int max = i;
        for(i=0;i<=last;i++){
            if(array[max]<array[i]){
                max=i;
            }
        }
        return max;   
    }


}
