package APNADSA.BinarySearchTree;

public class mirrorBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val= val;
        }
    }
    
    //swap the nodes of root's left and right
    public static void MirrorOfBst(TreeNode root){
        if(root == null){
            return;
        }
        MirrorOfBst(root.left);
        MirrorOfBst(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // InOrder traversal
    public static void printInOrder(TreeNode root){
        if(root == null){
            return;
        }
        printInOrder(root.left);
        System.out.print( root.val +" ");
        printInOrder(root.right);
    }


    public static void main(String args[]){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(11);
        printInOrder(root);
        System.out.println();
        MirrorOfBst(root);
        printInOrder(root);
        System.out.println();
    }
}
