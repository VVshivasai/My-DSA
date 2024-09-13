package APNADSA.BinaryTreeS;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class InvertTree {
    public boolean areInverted(TreeNode root1, TreeNode root2) {
        return areMirrors(root1, root2);
    }

    private boolean areMirrors(TreeNode node1, TreeNode node2) {
        // Base cases
        if (node1 == null && node2 == null) {
            return true;
        }
        if( node1 == null || node2 == null|| node1.val != node2.val ){
            return false;
        }
        boolean left = areMirrors(node1.left, node2.right);
        boolean right = areMirrors(node1.right, node2.left);

        return left && right;

        
       
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(5);

        InvertTree solution = new InvertTree();
        boolean result = solution.areInverted(root1, root2);
        System.out.println("Are the trees inverted? " + result); // Output: true
    }
}
  