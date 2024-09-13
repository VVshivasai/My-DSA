package APNADSA.QueueS;
/*
 * No of SubSets in a String or Any thing is 2^N
 * where N is length of String 
 * here , Back Track technique is Used
 * Space Complexity O(N)
 * Time Complexity O()
 */
public class SubSet {
    static void Subset(String str,int index,String ans){
        if(index == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        Subset(str, index+1, ans+str.charAt(index));
        Subset(str, index+1, ans);
    }
    public static void main(String[] args) {
        String str = "abcd";
        Subset(str,0,"");
    }

}
