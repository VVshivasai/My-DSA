package APNADSA.Bit_Manipulation;

public class ConvertCase {
    /** output  is type cast from int to char if we not , use (char) ouput will be 65,67 like this...! 
     */
    public static void main(String[] args) {
        for(char ch = 'A' ;ch <='Z';ch++){
            System.out.print( (char)(ch|' ') + " ");
        }
        System.out.println();
        for(char ch = 'a' ; ch<='z';ch++){
            System.out.print((char)(ch & (~(' ')))+" "); 
        }
    }

}
