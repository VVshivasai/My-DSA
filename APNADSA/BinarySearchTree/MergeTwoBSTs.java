package APNADSA.BinarySearchTree;


import java.util.*;

public class MergeTwoBSTs {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val= val;
        }
    }
    // Inorder traversal on BST
    public static void getInorder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        getInorder(root.left, list);
        list.add(root.val);
        getInorder(root.right, list);
    }

    public static TreeNode mergeBSTs(TreeNode root1, TreeNode root2){
        // step 1 : --> add elements of tree 1 into list1 by inorder traversal
        ArrayList<Integer> list1 = new ArrayList<>();
        getInorder(root1,list1);

        // step 2 : --> add elements of tree 2 into list2 by inorder traversal
        ArrayList<Integer> list2 = new ArrayList<>();
        getInorder(root2,list2);

        // step 3 : --> merge the two sorted list
        ArrayList<Integer> Mergedlist = new ArrayList<>();
        int n1 = list1.size();
        int n2 = list2.size();

        int i=0,j=0;
        while(i < n1 && j < n2){
            if(list1.get(i) <= list2.get(j)){
                Mergedlist.add(list1.get(i));
                i++;
            }else{
                Mergedlist.add(list2.get(j));
                j++;
            }
        }
        while(i < n1){
            Mergedlist.add(list1.get(i));
            i++;
        }
        while(j < n2){
            Mergedlist.add(list2.get(j));
            j++;
        }

        // step 4 :--> covert Sorted List into Balaned BST

        TreeNode root = ConvertToBST(Mergedlist,0,Mergedlist.size()-1);
        return root;
    } 
    // step 4 : --> converting list to Balanced BST
    private static TreeNode ConvertToBST(ArrayList<Integer> mergedlist, int s, int e) {
        if( s > e ){
            return null;
        }
        int mid = (s+e) /2;
        TreeNode root = new TreeNode(mergedlist.get(mid));
        root.left = ConvertToBST(mergedlist, s, mid-1);
        root.right = ConvertToBST(mergedlist, mid+1, e);
        return root;
    }

    public static void main(String []args){
        // Tree ONE 
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        // Tree TWO
        TreeNode root2 = new TreeNode(9);
        root2.left = new TreeNode(7);
        root2.right = new TreeNode(10);

        // output tree
        TreeNode root = mergeBSTs(root1, root2);
        getOutputInorder(root);

    }

    public static void getOutputInorder(TreeNode root){
        if(root == null){
            return;
        }
        getOutputInorder(root.left);
        System.out.print(root.val+" ");
        getOutputInorder(root.right);
    }
}
