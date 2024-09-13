package APNADSA.BinarySearchTree;

public class DeleteANode {
    static class TreeNode{
        TreeNode(int val){
            this.val = val;
        }
        int val;
        TreeNode left;
        TreeNode right;
    }
    public static TreeNode insert(TreeNode root,int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static void InOrder(TreeNode root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.val + " ");
        InOrder(root.right);
    }

    /*Delete A Node : --> Searhc the element first
     * Encounter with 3 cases:
     * --> case 1 : the node to be deleted is a leaf Node
     * --> case 2 : the node having only right childs or left childs
     * --> case 3 : the node with right and left nodes (InOrder Successor)
     *   InOrder Successor :--> it is the node always present in right side of Node at Left most
     */

    public static TreeNode DeleteNode(TreeNode root, int val){
        if(root.val > val){
            root.left = DeleteNode(root.left, val);
        }
        else if(root.val < val){
            root.right = DeleteNode(root.right, val);
        }else{
            if(root.left == null && root.right == null){ // case 1
                return null;
            }
            if(root.left == null){  // case 2
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode IN = FindInOrderSuccessor(root.right);
            root.val = IN.val;
            root.right = DeleteNode(root.right, IN.val);
        }
        return root;
    }

    static TreeNode FindInOrderSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String []args){
        int val[] = {8,5,3,1,4,6,10,11,14};
        TreeNode root = null;
        for(int i = 0; i<val.length;i++){
            root = insert(root,val[i]);
        }
        InOrder(root);
        System.out.println();
        root = DeleteNode(root, 5);
        InOrder(root);
        System.out.println();
    }
}
