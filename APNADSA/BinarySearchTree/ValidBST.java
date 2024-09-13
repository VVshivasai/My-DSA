package APNADSA.BinarySearchTree;

public class ValidBST {
    static class TreeNode {
        TreeNode(int val){
            this.val = val;
        }
        int val;
        TreeNode left;
        TreeNode right;   
    }
    // helper method
    public static boolean isValid(TreeNode root, TreeNode min, TreeNode max){
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min.val){
            return false;
        }
        if(max != null && root.val >= max.val){
            return false;
        }
        boolean left = isValid(root.left, min, root);
        boolean right = isValid(root.right, root, max);
        return left && right;
    }
    // actual method which is called by main method
    public static boolean isValidBST(TreeNode root){
        if(root == null) return true;
        return isValid(root,null,null);
    }

    public static void main(String []args){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(11);
        System.out.println(isValidBST(root));
    }
}
