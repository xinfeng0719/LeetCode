//create a HashTable, store the neweset position of every character. When iterate the whole string, we will put every character into the table.
//Meanwhile, we also have a parameter recording the current string's start position and a maximum length. 
//During our iterating, both start position and max length would be updated.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        int max = 0;
        int start = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))>=start){
                    start=map.get(s.charAt(i))+1;
                }
            }
            map.put(s.charAt(i),i);
            max = Math.max(i-start+1,max);
        }
        
        return max;
    }
}
