package APNADSA.Segment_Trees;
// Max Sub Array Sgment Tree
public class Segment_Tree {

    static int segmentTree[];

    public static void init(int n){
        segmentTree = new int[4*n];
    }

    public static int buildTree(int arr[],int i,int start, int end){

        if(start == end){
            segmentTree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end )/2;
        buildTree(arr, 2*i+1, start, mid); // divide 
        buildTree(arr, 2*i+2, mid+1, end);// divide
        return segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2]; // conquer
    }

    //Query on ST (qi,qj)
    public static int getSumUtil(int i , int si, int sj, int qi, int qj){
        if(qi>=sj || qj<=si){ // Non overlap condition
            return 0;
        }
        else if(qi <= si && qj >= sj){ // Complete OverLap condition
            return segmentTree[i]; // where "i" is the index of Segment Tree Array
        }else{ // Partially OverLap condition
            int mid =  (si+sj)/2;
            //left child + right child 
            int left =  getSumUtil(2*i+1, si, mid, qi, qj);
            int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }
    public static int  GetSum(int arr[],int qi, int qj){
        return getSumUtil(0,0,arr.length-1,qi,qj);
    }
    public static void UpdateUtil(int i, int si,int sj, int idx,int diff){
        if(si>idx || sj<idx){
            return; // given idx not include in this range
        }
        segmentTree[i] += diff;
        if(si != sj){
            int mid = (si+sj)/2;
            UpdateUtil(2*i+1, si, mid, idx, diff); // left of ST
            UpdateUtil(2*i+2, mid+1, sj, idx, diff); // right of ST
        }
    }
    public static void UpdateQuery(int arr[],int idx,int newValue){
        if(idx < arr.length){
            // Update in Arr[] --> O(1)
            int diff = newValue - arr[idx];
            arr[idx] = newValue;

            // Update in Segment Tree --> O(LogN)
            UpdateUtil(0,0,arr.length-1,idx,diff);
        }
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;

        init(n); // creation of segment tree with size of 4*n

        buildTree(arr, 0, 0, n-1); // build the segment tree

        //print Segment Tree
        for(int i = 0; i<4*n; i++){
            System.out.print(segmentTree[i] + " ");
        } 
        System.out.println();  

        // Given Query qi = 2, qj = 5
        System.out.println(GetSum(arr,2,5)); // 18

        // Update on Segment Tree
        UpdateQuery(arr,2,2);// where 2 is Index of input Arr

        // Updated Segment Tree 
        for(int i : segmentTree){
            System.out.print(i+ " ");
        }
        System.out.println();
        // After Updated i = 2 is 2 in the arr then sum of Query in range(qi=2,qj=5) 
        System.out.println(GetSum(arr, 2, 5)); // 17 
    }
}
