package APNADSA.BinarySearchTree;
import java.util.*;
public class PrintPaths {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }    
    }

    public static void printPath(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left == null && root.right == null){
            System.out.println(list);
        }
        printPath(root.left, list);
        printPath(root.right, list);
        list.remove(list.size()-1);
    }

    public static void main(String []args){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(10);

        printPath(root, new ArrayList<>());
    }
}
