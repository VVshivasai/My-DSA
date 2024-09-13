package APNADSA.Hashing;

import java.util.*;

public class Anagram {

    public static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }

        for(int i = 0; i< s2.length(); i++){
            if(map.get(s2.charAt(i) )!= null){
                if(map.get(s2.charAt(i))== 1){
                    map.remove(s2.charAt(i));
                }else{
                    map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
                }
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "race";
        String s2 = "reac";

        System.out.println(isAnagram(s1, s2));
    }
}
