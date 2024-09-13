package APNADSA.Recursion_BackTrack;



public class TilingProblem {
    static int CountWays(int n){
        if(n==0 || n==1){
            return 1;
        }
        int HoriZontal = CountWays(n-1); // horizontal Ways
        int Vertical = CountWays(n-2);   // vertical Ways
        return HoriZontal + Vertical;   // Total No of Ways
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(CountWays(n));
    }

}
