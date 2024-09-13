package APNADSA.StringsQuestions;

public class Add {
    static String Addition(String s1, String s2){
        StringBuffer sb = new StringBuffer();
        int carry =0;
        int i = s1.length()-1;
        int j = s2.length()-1;
        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0)sum += s1.charAt(i)-'0';
            if(j>=0)sum += s1.charAt(j)-'0';
            sb.append(sum%2);
            carry = sum/2;
            i--;
            j--;
        }if(carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String s1 = "111", s2 = "11";
        System.out.println();
        System.out.println(Addition(s1,s2));
        
    }

}
