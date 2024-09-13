package APNADSA.StringsQuestions;

/*
 * first check the both string lengths
 * covert strings into character array
 * sort the both arrays
 * check the characters of strings are equal 
 */
import java.util.*;
public class Anagram {
    public static void main(String[] args) {
        // input 
        String str1 = "dsaexpert";
        String str2 = "expeertdsa";
        //coverting str1 into character array 
        char arr1[] = new char[str1.length()];
        for(int i=0;i<arr1.length;i++){
            arr1[i] = str1.charAt(i);
        }
        //converting str2 into character array 
        char arr2[] = new char[str2.length()];
        for(int i=0;i<arr2.length;i++){
            arr2[i] = str2.charAt(i);
        }
        
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        // sort the character array of str1
        for(int i=0;i<arr1.length;i++){
            char curr = arr1[i];
            int prev = i-1;
            while(prev>=0 && curr<arr1[prev]){
                arr1[prev+1] = arr1[prev];
                prev--;
            }
            arr1[prev+1] = curr;
        }
        System.out.println(Arrays.toString(arr1));
        // sort the character array of str2
         for(int i=0;i<arr2.length;i++){
            char curr = arr2[i];
            int prev = i-1;
            while(prev>=0 && curr<arr2[prev]){
                arr2[prev+1] = arr2[prev];
                prev--;
            }
            arr2[prev+1] = curr;
         }
         System.out.println(Arrays.toString(arr2));
         // output
         boolean anagram = true;
         for(int i=0;i<arr1.length;i++){
             if(arr1[i]!=arr2[i]){
                 anagram = false;
                 System.out.println(anagram);
                 break;
            }
        }
        if(anagram == true){
            System.out.println(true);
        }
    }
}
