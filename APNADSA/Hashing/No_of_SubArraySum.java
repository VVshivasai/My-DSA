package APNADSA.Hashing;
import java.util.*;
public class No_of_SubArraySum {

    public static int findSubArraySum(int []nums, int k){
        int count = 0;
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,1); // it is a single element like i.e;[k]
        for(int i = 0; i<n; i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static void main(String args[]){
        int nums[] = {2,3,0,5,-2};
        int k = 3;
        System.out.println(findSubArraySum(nums,k));
    }
}
