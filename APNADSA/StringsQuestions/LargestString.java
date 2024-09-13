package APNADSA.StringsQuestions;
import java.util.*;
public class LargestString {
    public static String Largest(String arr[],int n){
        String large = arr[0];
        for(int i=1;i<n;i++){
            if(large.compareTo(arr[i])<0){             // time complexity O(n*length of String in each index)
                large = arr[i];
            }
        }
        return large;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        in.nextLine();                        /*In java,When you use nextInt() to read an integer, 
                                               it only consumes the integer value and leaves the newline character (\n)
                                                in the input buffer */ 
        String arr[] = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextLine();
        }
        in.close();
        System.out.println(Largest(arr,n));
    }
}
