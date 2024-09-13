package APNADSA.SortingS;
/*  For ascending order
 * 1. Select the smallest element's index 
 * 2. Swap it with ith element
 * 3. In this way sort the array 
 */




import java.util.*;
public class Seletion_Sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        in.close();
        SelctionSort(arr,n);
        System.out.print(Arrays.toString(arr));
    }
           // decreasing order sort
    static void SelctionSort(int[] arr, int n) {
        for(int i=0;i<n;i++){
            int large = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[large]){     // finding largest element's index 
                    large = j;
                }
            }
            int temp = arr[large];  // swap that with ith element
            arr[large] = arr[i];
            arr[i] = temp;
        }
    }
}
