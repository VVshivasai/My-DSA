package APNADSA.BinarySearchTree;


public class BST {
    static class TreeNode {
        TreeNode(int val){
            this.val =val;
        }
        int val;
        TreeNode left;
        TreeNode right;  
    }

    public  TreeNode insert(TreeNode root,int val){
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        else if(root.val < val){
            root.right = insert(root.right,val);
        }
        else{
            root.left = insert(root.left, val);
        }
        return root;
    }

    public  void InOrder(TreeNode root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.val + " ");
        InOrder(root.right);
    }

    public boolean Search(TreeNode root,int key){
        if(root == null){
            return false;
        }
        if(root.val == key){
            return true;
        }else if(root.val > key){
            return Search(root.left, key);
        }else{
            return Search(root.right,key);
        }

    }
    public static void main(String []args){
        BST obj = new BST();
        int value[] ={5,6,3,8,4,2,9,1,10,7};
        TreeNode root = null;
        for(int i = 0;i<value.length;i++){
            root = obj.insert(root, value[i]);
        }
        obj.InOrder(root);
        System.err.println();
        System.out.println(obj.Search(root, 10));
    }
}
