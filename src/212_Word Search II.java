public class Solution {
    class TrieNode{
        TrieNode[] next = new TrieNode[26];//in this question, from a to z
        String word;//constructor function is not needed since we don't need all Trie's characters
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        //build a Prefix Tree,then insert words into Prefix Tree, and search in the board, if exist, add to result
        //in detail, 1.build TrieNode, 2.build Trie using words,3.search in the board using Trie
        //Besides, we can do reversely, build Trie using board and then search words.
        TrieNode root = buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                search(board,i,j,root,result);
            }
        }
        return result;
    }
    public void search(char[][] board,int i,int j,TrieNode root,List<String> result){
        char cur = board[i][j];
        if(cur=='#'||root.next[cur-'a']==null) return;
        root = root.next[cur-'a'];
        if(root.word!=null){
            result.add(root.word);
            //bug here, fixed, after we find one word, we need to remove this word from our Trie for preventing duplicate
            root.word=null;
        }
        board[i][j]='#';
        //dfs
        if(i>0) search(board,i-1,j,root,result);
        if(j>0) search(board,i,j-1,root,result);
        if(i<board.length-1) search(board,i+1,j,root,result);
        if(j<board[0].length-1) search(board,i,j+1,root,result);
        board[i][j]=cur;
    }
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String s:words){
            TrieNode p = root;
            for(char c:s.toCharArray()){
                int i=c-'a';
                if(p.next[i]==null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = s;
        }
        return root;
    }
}
