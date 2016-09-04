public class Solution {
    class TrieNode{
        TrieNode[] next;
        int index;
        List<Integer> list;
        TrieNode(){
            next = new TrieNode[26];
            index = -1;//initialize with -1
            list = new ArrayList<Integer>();
        }
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(int i=0;i<words.length;i++){
            addWord(root,words[i],i);
        }
        for(int i=0;i<words.length;i++){
            searchWord(root,result,i,words);//for every word, we shall try the rest of the string to see if their concatenation is palindrome
        }
        return result;
    }
    private void searchWord(TrieNode root,List<List<Integer>> result,int index,String[] words){
        //compare with words[index]
        for(int i=0;i<words[index].length();i++){
            if(root.index>=0&&root.index!=index&&isPalindrome(words[index],i,words[index].length()-1)){
                result.add(Arrays.asList(index,root.index));//rest of the words[index] is palindrome, 0-i part can concat with words[root.index] to form palindrome, in that case, we find one palindrome
            }
            root = root.next[words[index].charAt(i)-'a'];
            if(root==null) return;
        }
        for(int k:root.list){
            if(index==k) continue;
            result.add(Arrays.asList(index,k));
        }
    }
    private void addWord(TrieNode root,String word,int index){
        for(int i=word.length()-1;i>=0;i--){
            char c = word.charAt(i);
            if(root.next[c-'a']==null){
                root.next[c-'a'] = new TrieNode();
            }
            if(isPalindrome(word,0,i)){
                root.list.add(index);
            }
            
            root = root.next[c-'a'];
        }
        root.index = index;
        root.list.add(index);
    }
    private boolean isPalindrome(String word, int i,int j){
        while(i<j){
            if(word.charAt(i++)!=word.charAt(j--)) return false;
        }
        return true;
    }
}
