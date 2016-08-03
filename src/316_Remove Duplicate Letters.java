//Maintain one array store the remaining character's number and the other array tracking the current visited character's situation
//The key is when we iterate the string, if the character is visited, then we continue loop. If the character is not visited, we check 
//if this character can append in our result string which follow the alphabetical order. If not, we remove the previous character, update the visited array.
//If yes, then we do nothing but append this character in the tail. 
public class Solution {
    public String removeDuplicateLetters(String s) {
        char[] array = s.toCharArray();
        StringBuilder result = new StringBuilder();
        int[] visit = new int[26];
        for(char c:array){
            visit[c-'a']++;
        }
        boolean visited[] = new boolean[26];
        for(char c:array){
            visit[c-'a']--;
            if(visited[c-'a']){
                continue;
            }
            while(result.length()>0&&c<=result.charAt(result.length()-1)&&visit[result.charAt(result.length()-1)-'a']>0){
                visited[result.charAt(result.length() - 1)-'a'] = false;
                result.deleteCharAt(result.length()-1);
            }
            result.append(c);
            visited[c-'a']=true;
        }
        return result.toString();
    }
}
