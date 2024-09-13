package APNADSA.TrieS;

public class FindLongestWordWIthAllPrefix {

    public static class TrieNode{
        TrieNode child[];
        boolean isEow;
        TrieNode(){
            child = new TrieNode[26];
            isEow = false;
        }
    }

    public static TrieNode root = new TrieNode();

    // Inserting array of words in trie

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


    // finding largest word which having its all prefix (lexicographically)
    public static String ans ="";

    public static void FindLargest(TrieNode root, StringBuffer temp){
        if(root == null){
            return;
        }
        for(int i = 0; i<26; i++){
            if(root.child[i] != null && root.child[i].isEow){
                temp.append((char) (i +'a'));
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                FindLargest(root.child[i],temp);
                //backtrack step : remove the character from temp
                temp.deleteCharAt(temp.length() -1);
            }
        }
    }
    
    public static void main(String[] args) {
        String words[] = {"a","ap","banana","bana","app","appl","apply","apple"};
        for(int i=0; i<words.length; i++){
            Insert(words[i]);
        }
        FindLargest(root,new StringBuffer());
        System.out.println(ans);
        
    }
}
