package APNADSA.BinaryTreeS;

import java.util.*;

/*
 * Pre Order Binary Tree
 * Process: --> step 1: create Node class with data, left node , right node
 *          --> step 2: create a method to Build Tree of return type Node
 *          --> step 3: intialize index with -1 intially with static 
 *          --> step 4: check that data is eqaul to -1 or not 
 *                         --> if it is -1 then return null (Base case)
 *          --> step 5: create a new Node and store data in it 
 *          --> step 6:recursively call left and right nodes untill
 */
public class BinaryTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int index = -1;
    // Build tree by using array
    public  Node BuildTree(int nodes[]){ // Time Complexity O(N)
        index++;
        if(nodes[index] == -1){
            return null;
        }
        Node newNode = new Node(nodes[index]);
        newNode.left = BuildTree(nodes);
        newNode.right= BuildTree(nodes);
        return newNode;
    }


    

    /* PreOrder Traversal --> O(N)
     * 
     * step 1 --> first print root value 
     * step 2 --> then call left sub tree
     * step 3 --> then call right sub tree
     */
    public void PreOrder_Traversal(Node root){  
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");
        PreOrder_Traversal(root.left);  // left sub tree called recursively 
        PreOrder_Traversal(root.right); // right sub tree called recurively
       
    }

    /* In Order Traversal --> O(N)
     * 
     * Step 1 --> first call left sub tree
     * step 2 --> then print root value 
     * step 3 --> next call right sub tree
     */

    public void InOrder_Traversal(Node root){
        if(root == null){
            return;
        }
        InOrder_Traversal(root.left);
        System.out.print(root.data +" ");
        InOrder_Traversal(root.right);
        
    }

    /* Post Order Traversal --> O(N)
     * 
     * Step 1 --> first call left sub tree
     * step 2 --> then call right sub tree
     * step 3 --> pritn the root value
     */

    public void PostOrder_Traversal(Node root){
        if(root == null){
            return;
        }
        PostOrder_Traversal(root.left);
        PostOrder_Traversal(root.right);
        System.out.print(root.data + " ");
    }
    /* Level Order Traversal (BFS) (Interview Question) Time Complexity O(N), S.C -> O(N)
     * check the given  tree is null or not if it is then simply return.
     * Step 1 --> Create a queue data structure with type Node 
     * Step 2 --> run while loop till queue is empty
     * Step 3 --> Take a node variable which is CurrNode , store the front value in it
     * Step 4 --> check  the currNode 
     *             --> if it is null then print next line 
     *             --> if it is not null then print data and add its next elements
     */
    public void LevelOrder_Traversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data +" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right!= null){
                    q.add(currNode.right);
                }
            }
        }
    }

    // Height of Tree (From Root Node to Leaf Node)

    public int Height_Of_Tree(Node root){ // Time Complexity --> O(N)
        if(root == null){
            return 0;
        }
        int leftHeight = Height_Of_Tree(root.left);
        int rightheigh = Height_Of_Tree(root.right);
        int maxHeight = Math.max(leftHeight,rightheigh);
        return maxHeight + 1;
    }

    // Count the Nodes in a tree

    public int CountNodes_In_aTree(Node root){ // Time Complexity --> O(N)
        if(root == null){
            return 0;
        }
        int leftCount = CountNodes_In_aTree(root.left);
        int rightCount = CountNodes_In_aTree(root.right);
        int count = leftCount + rightCount +1;
        return count;
    }

    // Sum of values in the Nodes 
    public int SuM_OF_Data(Node root){
        if(root == null) return 0;

        int leftSum = SuM_OF_Data(root.left);
        int rightSum = SuM_OF_Data(root.right);

        return leftSum + rightSum + root.data;

    }
    static class Info{
        Node node;
        int hd;
        Info(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public void TopView_BottomView(Node root){
        int min = 0;
        int max = 0;
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        q.add(new Info(root,0));
        q.add(null);
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                //map.put(curr.hd,curr.node); // for Bottom view (remove if condition) upadate map with new values
                //if(!map.containsKey(curr.hd)){ 
                    map.put(curr.hd,curr.node);
              // }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }

        }
        for(int i = min; i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
            
    }

    // Main method 
    public static void main(String args[]){
        int nodes[] = {1,2,3,-1,-1,4,-1,-1,5,-1,-1};
        /*
         *           1 (root node)
         *          / \
         *         2   5
         *        / \
         *       3   4
         */  
        BinaryTree bt = new BinaryTree();
        Node root =bt.BuildTree(nodes);
        bt.PreOrder_Traversal(root); // travelled by DFS
        System.out.println();
        bt.InOrder_Traversal(root); // travelled by DFS
        System.out.println();
        bt.PostOrder_Traversal(root); // travelled by DFS
        System.out.println();
        bt.LevelOrder_Traversal(root); // travelled by BFS 

        System.out.println(bt.Height_Of_Tree(root)); // height of tree

        System.out.println(bt.CountNodes_In_aTree(root)); // count the no of nodes in tree

        System.out.println(bt.SuM_OF_Data(root)); // Sum of all values in the Tree

        bt.TopView_BottomView(root); // top view 
    }

}
