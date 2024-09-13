package APNADSA.TrieS;
// asked in google , microsoft
public class FInd_Unique_SubStrings {
    public static class TrieNode{
        TrieNode child[];
        boolean isEow;
        TrieNode (){
            child = new TrieNode[26];
            isEow = false;
        }
    }
    public static TrieNode root = new TrieNode();

    // Inserting suffixes of string in to trie 

    public static void Insert(String word){
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new TrieNode();
            }
            curr = curr.child[idx];
        }
        curr.isEow = true;
    }

    // Suffix of given String input

    public static void Suffix(String input){
        for(int i = 0; i< input.length(); i++){
            Insert(input.substring(i));
        }
    }

    // count the no of nodes in a Trie which gives the unique substrings count

    public static int CountNodesInTrie(TrieNode root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i = 0; i< 26; i++){
            if(root.child[i] != null){
                count += CountNodesInTrie(root.child[i]);
            }
        }
        return count +1;
    }

    // helper method 
    public static int HelpForOuput(String input){
        return CountNodesInTrie(root);
    }


    // main method
    public static void main(String args[]){
        String input = "ababa";
        Suffix(input);
        System.out.println(HelpForOuput(input));
    }
}
