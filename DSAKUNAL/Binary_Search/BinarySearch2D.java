package  DSAKUNAL.Binary_Search;

import java.util.Arrays;
import java.util.Scanner;
public class BinarySearch2D {
    public static void main(String[] args) {   //BinarySearch in 2D arrays
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int array[][] = new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                array[i][j] = in.nextInt();
            }
        }
        int target = in.nextInt();
        in.close();
        int ans[] = Search(array,target);
        System.out.print(Arrays.toString(ans));
        
    }
    public static int[] Search(int [][]arra,int tar){
        int start = 0;
        int end = arra.length-1;

        while(start<=end){
            int mid= arra[start][end];
            if(tar==mid){
                return new int[] {start,end};
            }else if(tar<arra[start][end]){
                end--;
            }else{
                start++;
            }
        }
        return new int[]{-1,-1};

    }

}
