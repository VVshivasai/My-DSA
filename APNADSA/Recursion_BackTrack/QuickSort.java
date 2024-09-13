package APNADSA.Recursion_BackTrack;



import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int nums[],int start,int end){
        if(start>=end){
            return;
        }
        int pivotIndex = pivot(nums,start,end);
        quickSort(nums, start, pivotIndex-1);
        quickSort(nums, pivotIndex+1, end);

    }
    static int pivot(int nums[],int start, int end){
        int pivot = nums[end];
        int i = start-1;
        for(int j = start ; j<end;j++){
            if(nums[start]<= pivot){
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        nums[end] = nums[i];
        nums[i] = temp;
        return i;
    }
    public static void main(String[] args) {
        int nums[] = {5,4,3,2,1};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}
