package APNADSA.BinarySearchTree;
import java.util.*;

/*               Input                                    output
 *                 8                                        8
 *                / \                                      /  \
 *               7   9                                    6    10
 *              /     \                ==>               / \   / \
 *             6       10                               5   7 9   11
 *            /         \
 *           5           11
 * 
 */

public class ConvertBST_to_BalancedBST {
    static class TreeNode{
        int val;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode left;
        TreeNode right;
    }
    // Creating a list of elements in sorted order for creating "Balanced  BST" by using BST
    public static void  FindsortOrder(TreeNode root,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        FindsortOrder(root.left, list);
        list.add(root.val);
        FindsortOrder(root.right, list);
    }
    // construct balanced bst by using sorted list
    public static TreeNode BuildBAL_BSAT(ArrayList<Integer> list,int s, int e){
        if(s>e){
            return null;
        }
        int mid = (s+e)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = BuildBAL_BSAT(list, s, mid-1);
        root.right = BuildBAL_BSAT(list, mid+1, e);
        return root;
    }
    // Convert BST to BAL BST, this is called by main method 
    public static TreeNode ConvertBST_To_BAL_BST(TreeNode root){
        if(root == null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        FindsortOrder(root,list);
        root = BuildBAL_BSAT(list,0,list.size()-1);
        return root;
    }

    public static void printBSTInOrder(TreeNode root){
        if(root == null){
            return;
        }
        printBSTInOrder(root.left);
        System.out.print( root.val +" ");
        printBSTInOrder(root.right);
    }

    public static void printBSTPreOrder(TreeNode root){
        if(root  == null){
            return;
        }
        System.out.print(root.val +" ");
        printBSTPreOrder(root.left);
        printBSTPreOrder(root.right);
    }
    public static void main(String args[]){  
        TreeNode root = new TreeNode(8);  // Input BST
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(10);
        root.right.right.right = new TreeNode(11);
        printBSTInOrder(root);
        System.out.println();
        root = ConvertBST_To_BAL_BST(root);  // Output Balanced BST
        printBSTPreOrder(root);
    }

}
