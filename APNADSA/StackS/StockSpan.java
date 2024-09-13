package APNADSA.StackS;

import java.util.*;;

public class StockSpan {
    static int[] StocksSpan(int []stocks){
        int span[] = new int[stocks.length];
        Stack<Integer> st = new Stack<>();
        span[0] = 1;
        st.push(0);
        for(int i=1;i<stocks.length;i++){
            int currentPrice = stocks[i];
            while(!st.isEmpty() && currentPrice > stocks[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                span[i] = i+1;
            }else{
                int prevHigh = st.peek();
                span[i] = i-prevHigh;
            }
            st.push(i);
        }
        return span;
    }
    public static void main(String args[]){
        int stocks[] = {100,80,70,60,70,85,100};
        System.out.println(Arrays.toString(StocksSpan(stocks)));
    }

}
