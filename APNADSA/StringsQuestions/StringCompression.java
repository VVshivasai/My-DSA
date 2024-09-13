package APNADSA.StringsQuestions;

import java.util.*;                            // Amazon question 

public class StringCompression {
    public static String Comp(String str){
        int n = str.length();
        StringBuilder newStr = new StringBuilder("");  // Using Stringbuilder for Efficience
        for(int i=0;i<n;i++){
            Integer count = 1;
            while(i<n-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            newStr.append(str.charAt(i));
            if(count > 1){
                newStr.append(count.toString());
            }
        }
        return newStr.toString();
    }

    public static String Compression(String str){
        String newStr = "";       // Using String Class
        int n = str.length();
        for(int i=0;i<n;i++){                //  time complexityO(N) because i++ is also in while loop
            Integer count = 1;                            // ***It is not efficient internally takes more space 
            while(i<n-1 && str.charAt(i)==str.charAt(i+1)){  //and time beacause of String class.
                count++;                                        
                i++;
            }
            newStr += str.charAt(i);  // append character 
            if(count>1){
                newStr += count.toString();  // append number 
            }
        }
        return newStr;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        System.out.println(Compression(str));
        System.out.println(Comp(str));
    }


}
