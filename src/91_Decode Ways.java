public class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0') return 0;
        //one char or two char  12->1 ,1,2-1+1(due to 12),123 -1,2,3
        int dp[] = new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        int total=1;
        for(int i=1;i<s.length();i++){
            int oneChar,twoChar;
            if(s.charAt(i)=='0'){
                oneChar = 0;
            }else{
                oneChar=1;
            }
            if((s.charAt(i-1)=='1')||(s.charAt(i-1)=='2'&&s.charAt(i)<='6')){
                twoChar = 1;
            }else{
                twoChar = 0;
            }
            dp[i+1] = oneChar*dp[i]+twoChar*dp[i-1];
        }

        return dp[s.length()];
    }
}
