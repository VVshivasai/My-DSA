package APNADSA.Recursion_BackTrack;



// print n to 1 numbers


public class PrintNum {
    static void Print(int n){
        if(n==1){ // Base Case
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        Print(n-1); // Call previous number to function
    }
    public static void main(String[] args) {
        int n = 10;
        Print(n);
    }

}
