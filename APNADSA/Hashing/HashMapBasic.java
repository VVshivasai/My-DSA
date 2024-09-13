package APNADSA.Hashing;
import java.util.*;
public class HashMapBasic {

    public static void main(String args[]){
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India",2000);
        hm.put("China",10000);
        hm.put("Pakisthan",1000);
        hm.put("US",1500);

        // Iteration through map using set

        Set<String> keys = hm.keySet();

        for(String key : keys){
            System.out.println("Key :"+ key + " ,Value :"+ hm.get(key));
        }
    }

}
 