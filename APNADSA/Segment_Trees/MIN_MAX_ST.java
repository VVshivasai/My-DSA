package APNADSA.Segment_Trees;

/* Same Logic for MIN Segment Tree 
 * Only One change that is in the place of Every max ,--> put min
 * Change Integer.MIN_VALUE to Integer.MAX_VALUE
 */

public class MIN_MAX_ST {
    static int segmentTree[];

    public static void init(int n){ // Intialization of tree
        segmentTree = new int[4*n];
    }

    public static void buildTree(int i, int arr[], int si, int sj){ // Creation of Max/Min Tree -->O(N)
        if(si == sj){
            segmentTree[i] = arr[si];
            return;
        }
        int mid = (si+sj)/2;
        buildTree(2*i+1, arr, si, mid); // left child
        buildTree(2*i+2, arr, mid+1, sj); // right child

        segmentTree[i] = Math.max(segmentTree[2*i+1],segmentTree[2*i+2]); // if we want "min" then change max to min
        return;
    }
    // Get Maximum Element in given Sub Array (i,j)
    public static int getMaxUtil(int i,int si,int sj, int qi,int qj){
        //case 1: query and segment tree are  Non Overlapping 
        if(si>qj || sj<qi){
            return Integer.MIN_VALUE; // Non Overlap Case
        }
        //case 2 : Query and segemt tree are completely Overlap
        else if(si>=qi && sj<=qj){ 
            return segmentTree[i];
        }
        // case 3: Partially Overlap
        else{
            int mid = (si+sj)/2;
            int left = getMaxUtil(2*i+1, si, mid, qi, qj);
            int right = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(left,right);
        }
    }
    public static int GetMax(int arr[], int qi, int qj){
        return getMaxUtil(0,0,arr.length-1,qi,qj);
    }

    // Update ST when Change in Arr

    public static void updateST_Util(int i, int si, int sj, int idx, int newValue){
        if(idx<si || idx>sj){
            return;
        }

        if(si == sj){
            segmentTree[i] = newValue;
        }
        if(si != sj){
            segmentTree[i] = Math.max(segmentTree[i],newValue);
            int mid = (si+sj)/2;
            updateST_Util(2*i+1, si, mid, idx, newValue);
            updateST_Util(2*i+2, mid+1, sj, idx, newValue);
        }
    }
    public static void updateST(int arr[], int idx,int newValue){
        if(idx<arr.length){
            arr[idx] = newValue; // Updation -->O(1)
        }

        // Fix the Segment Tree -->O(logN)
        updateST_Util(0,0,arr.length-1,idx, newValue);
    }

    public  static void main (String []args){
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;

        //call for Intialization ST
        init(n);
        //Build the ST in which "every Node having Max Value in Subarray ranges from(i,j)"
        buildTree(0,arr,0,n-1);

        Print(segmentTree);

        System.out.println(GetMax(arr, 2, 5)); // 17 is Max  in range[-1,2,17,1]
        
        System.out.println(GetMax(arr, 0, 3)); // 8 (before Update)[6,8,-1,2]

        updateST(arr,2,9); //change -1 as 9

        Print(segmentTree); // After Update the segment tree called Print method 

        System.out.println(GetMax(arr, 0, 3)); // 9 (after Update)[6,8,9,2] 


    }

    // Print Method of ST
    static void Print(int ST[]){
        for(int i : ST){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
