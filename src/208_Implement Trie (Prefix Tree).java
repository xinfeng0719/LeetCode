class TrieNode {
    // Initialize your data structure here.
    public String val;
    public TrieNode[] next;
    public TrieNode() {
        next = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root = insert(word,root,0);
    }
    public TrieNode insert(String word,TrieNode root,int index){
        if(root==null) root = new TrieNode();
        if(index==word.length()){
            root.val = word;
            return root;
        }
        int c = word.charAt(index);
        root.next[c-'a'] = insert(word,root.next[c-'a'],index+1);
        return root;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(word,root,0);
    }
    public boolean search(String word,TrieNode root,int index){
        if(root==null) return false;
        if(index==word.length()&&root.val==null) return false;
        if(index==word.length()&&root.val!=null) return true;
        int c = word.charAt(index);
        return search(word,root.next[c-'a'],index+1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return startsWith(prefix,root,0);
    }
    public boolean startsWith(String prefix,TrieNode root,int index){
        if(root==null) return false;
        if(index==prefix.length()) return true;
        int c = prefix.charAt(index);
        return startsWith(prefix,root.next[c-'a'],index+1);
    }
}
