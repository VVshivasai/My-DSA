package  DSAKUNAL.Bubble_Sort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int array[] = new int[size];
        for(int i=0;i<size;i++){
            array[i]=in.nextInt();
        }
        in.close();
        bubbleSort(array,size);
    }
    public static void bubbleSort(int[] array,int size){
        boolean swap = false; // for O(N) case
        for(int i=0;i<size;i++){
            for(int j=1;j<size-i;j++){
                if(array[j]<array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    swap = true;
                }
            }
            if(swap==false){
                break; // if there is no swap occurs then i=0; loop breaks.best case
            }
        }
        System.out.print(Arrays.toString(array));
    }

}
