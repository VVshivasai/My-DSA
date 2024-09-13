package APNADSA.TrieS;

import java.util.ArrayList;

public class ShortestUnique_Prefix {
    //creating trie node
    public static class TrieNode{
        TrieNode child[];
        boolean isEow;
        int freq;
        TrieNode(){
            child = new TrieNode[26];
            isEow = false;
            freq = 1;
        }
    }
    public static TrieNode root = new TrieNode();


    // Insert word in TrieNode
    public static void Insert(String word){
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new TrieNode();
            }else{
                curr.child[idx].freq ++;
            }
            curr = curr.child[idx];
        }
        curr.isEow = true;
    }

    // find shortest unique prefix

    public static void Prefix(TrieNode root, String ouput, ArrayList<String> list){
        if(root == null){
            return;
        }
        if(root.freq == 1){
            list.add(ouput);
            return;
        }
        for(int i = 0; i<26; i++){
            if(root.child[i] != null){
                Prefix(root.child[i], ouput + (char)(i+'a'), list);
            }
        }
    }
    public static void main(String[] args) {
        String []words = {"zebra","dog","dove","duck"};
        for(String word : words){
            Insert(word);
        } 
        root.freq = -1;
        ArrayList<String> list = new ArrayList<>();
        Prefix(root,"",list);
        System.out.println(list);
    }

}
