package APNADSA.GreedyAlgo;

import java.util.*;

/*
 * https://www.geeksforgeeks.org/problems/job-sequencing-
 * problem-1587115620/1?page=1&sprint=490b83535d472f23ece02016c39d5fb6&sortBy=submissions
 */
public class Job_Sequence_Problem {
    public  static class Job{
        int id; 
        int deadLine;
        int profit;
        public Job(int i, int d,int p){
            id = i;
            deadLine = d;
            profit = p;
        }
    }

    public static void main(String []args){
        // from here to --->
        int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,20}};
        int n = jobsInfo.length;
        ArrayList<Job>list = new ArrayList<>();

        for(int i = 0;i<n;i++){
            list.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }
        // <---to here, it is input 



        // to get maximum profit , Sort in descending order based on Profit

        Collections.sort(list,(obj1,obj2) -> obj2.profit - obj1.profit);

        int time  = 0;
        int maxProfit = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i< list.size(); i++){
            Job curr = list.get(i);
            if(curr.deadLine > time){
                time++;
                ans.add(curr.id);
                maxProfit += curr.profit;
            }
        }

        System.out.println(maxProfit);
        System.out.println(ans);
    }

}
