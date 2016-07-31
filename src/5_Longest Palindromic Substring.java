//typical two dimision DP problem, allocate the case from j to i.
//the special case is when i-j<=2, aba, is a palindromic string
public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];//whether from i to j is a palindrome
        int start = 0;
        int end = 0;
        int max = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j)&&(i-j<=2||dp[j+1][i-1])){
                    dp[j][i]=true;
                    if(max<i-j+1){
                        max = i-j+1;
                        start=j;
                        end=i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
