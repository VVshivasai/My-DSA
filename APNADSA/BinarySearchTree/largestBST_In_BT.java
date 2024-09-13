package APNADSA.BinarySearchTree;

public class largestBST_In_BT {
    public static class TreeNode{
        int val;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode left;
        TreeNode right;
    }

    public static class Info{  // It gives every datails of each root
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST,int size,int min,int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    static int maxSize = 0; // to track max size of proper BST in BT

    public static  Info largestBst(TreeNode root){
        if(root == null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        // call left subtree to get its info
        Info leftInfo = largestBst(root.left);
        // call right subtree to get its info
        Info rightInfo = largestBst(root.right);
        // self root's info 
        int size = leftInfo.size + rightInfo.size +1;
        int min = Math.min(root.val,Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(root.val,Math.max(leftInfo.max,rightInfo.max));

        // check that from root, it is a proper BST
        if(root.val <= leftInfo.max || root.val >= rightInfo.min){
            return new Info(false,size,min,max);
        }

            // check that root's left and right are proper BSTs

            if(leftInfo.isBST && rightInfo.isBST){
            // update maxSize because we found a proper BST
            maxSize = Math.max(size,maxSize);
            return new Info(true, size, min, max);
        }

        //if it's left or right any one is false then it returns false
        return new Info(false, size, min, max);
    }    
    public static void main(String args[]){
        TreeNode root = new TreeNode(50);
        // left sub tree
        root.left = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);
        // right sub tree
        root.right = new TreeNode(60);
        root.right.left  = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);
    
        Info result = largestBst(root);
        System.out.println(result.size); // size of BT
        System.out.println(maxSize); // size of MAX proper BST in BT
    }
}
