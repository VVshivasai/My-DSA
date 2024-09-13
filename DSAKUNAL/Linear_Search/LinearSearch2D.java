package DSAKUNAL.Linear_Search;

import java.util.Arrays;
import java.util.Scanner;

class LinearSearch2D {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int array[][] = new int [size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                array[i][j] = in.nextInt();
            }
        }   
        int target = in.nextInt();
        in.close();
        LinearSearch2D obj = new LinearSearch2D();
        int []ans = obj.Search(array,target);
        System.out.print(Arrays.toString(ans));

    }

    int[] Search(int[][] array, int target) {
        for (int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                if(array[i][j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};  
    }

}
