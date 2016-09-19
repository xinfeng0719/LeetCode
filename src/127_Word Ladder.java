public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int level = 0;
        //every round, depending on possible transformation string, found possible next string,once = end words, quit
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String cur = queue.poll();
                if(cur.equals(endWord)) return level+1;//level start with 0, so return level+1
                //found possible transformation in the next round
                for(int j=0;j<cur.length();j++){
                    char[] word = cur.toCharArray();
                    for(char ch='a';ch<='z';ch++){
                        word[j]=ch;
                        String next = new String(word);
                        if(!next.equals(cur)&&wordList.contains(next)){
                            queue.add(next);
                            wordList.remove(next);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
