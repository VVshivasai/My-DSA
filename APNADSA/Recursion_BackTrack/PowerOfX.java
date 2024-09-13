package APNADSA.Recursion_BackTrack;


/*
 * logic -> x * x^n-1 * x^n-2 *.....x^0
 */
public class PowerOfX {
    static int pow(int x,int n){  //  T.C  -> O(N)
        if(n==0){
            return 1;
        }
        return x * pow(x , n-1);
        
    }
    /*
     * logic -> x^n/2 * x^n/2 for even
     * logic -> x^n/2 * x^n/2 * x for Odd 
     */
    static int OptimizedPow(int x,int n){
        if (n == 0) {
            return 1;
        }
        int halfPow = OptimizedPow(x, n / 2);
        int ans = halfPow * halfPow;
        if (n % 2 == 1) {
            ans *= x;
        }
        return ans;
        
    }
    public static void main(String[] args) {
       int n = 3;
       int x = 5;
       System.out.println(pow(x,n));
       System.out.println(OptimizedPow(x, n));
    }

}
