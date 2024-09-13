package APNADSA.QueueS;

public class LastOccurence {
    static int Last_Occurence(int arr[], int key, int i){
        if(i==arr.length){
            return -1;
        }
        int found = Last_Occurence(arr, key, i+1);
        if(found == -1 && arr[i] == key){
            return i;
        }
        return found;
    }
    public static void main(String[] args) {
        int arr[] = {2,3,4,5,7,7,7,8,3};
        int key = 7;
        System.out.println(Last_Occurence(arr,key,0));
    
    }

}
