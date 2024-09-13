package APNADSA.TrieS;


public class Trie__Implementation {

    public static class TrieNode {
        TrieNode []children;
        boolean isEow;
        public TrieNode(){
            children = new TrieNode[26];
             isEow = false;
        }

        public static TrieNode root = new TrieNode();

        // Insert in TrieNode 
        public static void Insert(String word){  //Time Complexity O(L) where L is larget word in the array
            /* Take a variable TrieNode , assign root to it.
             * run a for loop till the word length
             * take index of character at i
             * check that it is null or having a node in it
             * if not having create a trieNode 
             * update curr node with children which is created newly
             * after the loop assign true to isEow
             */
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

        // Search in a Trie 
        public static boolean Search(String target){ // Time Complexity O(N)
            /*Take a curr variable of type TrieNode
             * Run a for loop till target length
             * take indx of character in string
             * check if it is null or TrieNode, if null return false
             * check for next character
             * after loop return true 
             */
            TrieNode curr = root;
            for(int i=0; i<target.length(); i++){
                int idx = target.charAt(i) - 'a';
                if(curr.children[idx] == null){
                    return false;
                }
                curr  = curr.children[idx];
            }
            return curr.isEow;
        }

        //Prefix Check same like search method 

        public static boolean startsWiht(String prefix){ // continues part in a word
            TrieNode curr = root;
            for(int i=0; i<prefix.length(); i++){
                int idx = prefix.charAt(i) - 'a';
                if(curr.children[idx] == null){
                    return false;
                }
                curr  = curr.children[idx];
            }
            return  true;
        } 
        public static void main(String []arga){

            String []words = {"tree","google","googie","googed"};
            for(int i = 0; i<words.length; i++){
                Insert(words[i]);
            }
            System.out.println(Search("tree"));
            System.out.println(startsWiht("trek"));
        }
    }
}
