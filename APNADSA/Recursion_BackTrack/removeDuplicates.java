package APNADSA.Recursion_BackTrack;



public class removeDuplicates {
    static void DR(String str,StringBuilder sb,int idx,boolean map[]){
        if(idx == str.length()){
            System.out.print(sb);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a']==true){
           DR(str,sb,idx+1,map);
        }else{
            map[currChar-'a'] = true;
            DR(str,sb.append(currChar),idx+1,map);
        }
    }
    public static void main(String[] args) {
        String str = "appnnacollege";
        DR(str, new StringBuilder(),0,new boolean[26]);
    }

}
