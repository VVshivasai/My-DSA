package APNADSA.BinaryTreeS;

public class RemoveLeafNodeWithTarget {
    public static class TreeNode {
        TreeNode(int val){
            this.val = val;  
        }
        int val;
        TreeNode left;
        TreeNode right;
    }
    public void Print(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        Print(root.left);
        Print(root.right);
    }

    public TreeNode removeLeafnode(TreeNode root,int target){
        if(root == null){
            return null;
        }
        root.left = removeLeafnode(root.left,target);
        root.right = removeLeafnode(root.right,target);

        if(root.left == null && root.right == null){
            if(root.val == target){
                return null;
            }
        }
        return root;
    }

    public static void main(String []args){
        RemoveLeafNodeWithTarget obj = new RemoveLeafNodeWithTarget();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(2);
        root.left.right = new TreeNode(2);
        /*
         *               1
         *              / \
         *             3    2
         *            / \    \
         *           2   2    2 
         * 
         */
        int target = 2;
        obj.Print(root);
        System.out.println();
        obj.removeLeafnode(root,target);
        obj.Print(root);
        
    }
}
