package APNADSA.Hashing;

import java.util.*;

public class Union__Intersection {
// Union of two arrays
    public static LinkedHashSet<Integer> FIndUnion(int[]arr1, int []arr2){
        // add elements into set 
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i = 0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i = 0; i<arr2.length; i++){
            set.add(arr2[i]);
        }
        return set;
    }
// Intersection of two arrays
    public static ArrayList<Integer> Find_Intersection(int []arr1, int []arr2){
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i< arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i = 0; i< arr2.length; i++){
            if(set.contains(arr2[i])){
                list.add(arr2[i]);
                set.remove(arr2[i]);
            }
        }
        return list;
    }

    public static void main(String args[]){
        int arr1[] = {3,5,2,3,5,8,2,1,35,5};
        int arr2[] = {4,6,2,8,2,0};

        System.out.println(FIndUnion(arr1,arr2));
        System.out.println(Find_Intersection(arr1,arr2));
    }
}
