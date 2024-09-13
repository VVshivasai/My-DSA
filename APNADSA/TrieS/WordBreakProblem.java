package APNADSA.TrieS;
//https://leetcode.com/problems/word-break/description/


public class WordBreakProblem {

    // creating a trie;
    public static class TrieNode {
        TrieNode children[];
        boolean isEow;
        public TrieNode(){
            children = new TrieNode[26];
            isEow = false;
        }
    }
    
        TrieNode root = new TrieNode();
    // insert in trie
    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEow = true;
    }
    // search in a trie

    public boolean search(String key){
        TrieNode curr = root;
        for(int i=0; i<key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.isEow;  
    }

    //word break logic 
    public boolean wordBreak(String []words,String key ){
        if(key.length() == 0 ){
            return true;
        }
        
        /*Run loop from i = 1 to <=length()
        * for substring(0,i) 
        */
        for(int i = 1; i<=key.length(); i++){
            if(search(key.substring(0,i)) &&
                wordBreak(words,key.substring(i))){
                    return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        WordBreakProblem obj = new WordBreakProblem();
        String words[] = {"i","like","sam","samson","dsa"};
        String key = "ilikedsa";
        for(String word : words){
            obj.insert(word);
        }
        System.out.println(obj.wordBreak(words, key));
    }
}