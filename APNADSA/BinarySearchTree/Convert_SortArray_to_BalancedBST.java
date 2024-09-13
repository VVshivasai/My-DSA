package APNADSA.BinarySearchTree;

public class Convert_SortArray_to_BalancedBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val= val;
        }
    }

    public static TreeNode BuildBST(int arr[],int s,int e){
        // Base Case
        if(s>e){
            return null;
        }
        // mid of the array
        int mid = (s+e)/2;
        TreeNode root = new TreeNode(arr[mid]);
        // left half of array
        root.left  = BuildBST(arr, s, mid-1);
        // right half of array
        root.right = BuildBST(arr, mid+1, e);
        // single element
        return root;
    }
    // print the tree 
    public static void PrintBST(TreeNode root){
        if(root == null){
            return;
        }
       // System.out.print(root.val +" ");
        PrintBST(root.left);
        System.out.print(root.val +" ");
        PrintBST(root.right);
    }

    public static void main(String args[]){
        int arr[] = {3,5,6,7,8,9,10};
        TreeNode root = BuildBST(arr,0,arr.length-1);
        PrintBST(root);
    }
}
