package APNADSA.Bit_Manipulation;



public class BitOperations {
    static int fastExponentiation(int a, int n){  // fast exponentiation O(logN)***IMP
        int ans = 1;
        while(n>0){
            if((n&1)!=0){
                ans = ans*a;
            }
            a = a*a;
            n = n>>1;
        }
        return ans ;

    }    // end of Fast Exponentiation method    
  // Bit Operations set,clear,update,get.
    static int Set_Ith_Bit(int n, int i){
        int bitMask = 1<<i;
        return n | bitMask;

    }
    static int Clear_Ith_Bit(int n, int i){ // clear i th bit 
        int bitMask = ~(1<<i); 
        return n & bitMask;
    }
    static int Update_Ith_bit(int n, int i,int newBit){
        n = Clear_Ith_Bit(n, i); 
        n = n & (~(1<<i));      // logic for clear i th bit . Above clear_Ith_Bit and this line both are same
        int bitMask = newBit << i;
        return n|bitMask;
    }
    static int Get_Ith_Bit(int n,int i){
        int bitMask = 1<<i;
        if((n&bitMask)!=0){
            return 1;
        }else{
            return 0;
        }
    }
    static int ClearLast_I_Bits(int n, int i){
        int bitMask = ~0 << i+1;
        return n & bitMask;
    }
    static int Clear_Bits(int n, int i, int j){  // clear bits in between range
        int a = ~0<<j+1;
        int b = (1<<i)-1;
        int bitMask = a|b;
        return n & bitMask;
    }
    
    public static void main(String[] args) {
        System.out.println();

        //System.out.println(Clear_Bits(8, 2, 4));

        // System.out.println(fastExponentiation(5, 8));

        // System.out.println(Clear_Ith_Bit(20,4));

        // System.out.println(Set_Ith_Bit(20,3));

        // System.out.println(Update_Ith_bit(20, 2, 0));

        //System.out.println(Get_Ith_Bit(10,3));

        System.out.println(ClearLast_I_Bits(63,4));

    }

}
