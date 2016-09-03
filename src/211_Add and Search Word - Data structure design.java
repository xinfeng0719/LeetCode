public class WordDictionary {
    class TrieNode{
        TrieNode[] next;
        public String word;
        public TrieNode(){
            next = new TrieNode[26];
        }
    }
    TrieNode root;
    public WordDictionary(){
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(cur.next[index]==null) cur.next[index] = new TrieNode();
            cur = cur.next[index];
        }
        cur.word = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word,root,0);
    }
    public boolean search(String word,TrieNode node,int index){
        if(node==null) return false;
        if(index==word.length()&&node.word!=null) return true;
        if(index==word.length()&&node.word==null) return false;
        char c = word.charAt(index);
        //figure out .
        if(c=='.'){
            //iterate all node.next 
            for(TrieNode child:node.next){
                //return search(word,child,index+1); if we directly return false even we have true later
                //we will not return false here, we shall only return false if we don't find any true here
                if(search(word,child,index+1)) return true;
            }
        }else{
            //find certian next
            return search(word,node.next[c-'a'],index+1);
        }
        return false;//return false after iterate all TrieNode child
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
