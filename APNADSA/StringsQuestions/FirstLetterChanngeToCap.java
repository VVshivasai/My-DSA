package APNADSA.StringsQuestions;

// time complexity O(N) , asked in Code Nation
                           
public class FirstLetterChanngeToCap {
    public static String ChangeLetterToUpper(String str){
        StringBuilder sb = new StringBuilder("");      // create sb named string with ""
        char ch = Character.toUpperCase(str.charAt(0));  // convert first letter to UpperCase
        sb.append(ch);          
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()){   // check if any space , 
                sb.append(str.charAt(i));              //if it is ,then append it
                i++;                                       // increease index 
                sb.append(Character.toUpperCase(str.charAt(i))); // convert letter to upper and append
            }else{
                sb.append(str.charAt(i));  // if not ,then append it, as it is....
            }
        }
        return sb.toString();  // covert this StringBuilder class to String class

    }
    public static void main(String[] args) {
        String str = "hi, i am shiva";
        System.out.print(ChangeLetterToUpper(str));
        

    }

}
