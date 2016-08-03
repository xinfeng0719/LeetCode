public class Solution {
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        int count;
        String s="1";
        for(int i=1;i<n;i++){
            result.setLength(0);
            count=1;
            for(int j=1;j<s.length();j++){
                if(s.charAt(j)!=s.charAt(j-1)){
                    result.append(count);
                    result.append(s.charAt(j-1));
                    count=0;
                }
                count++;
            }
            //reach the end, we shall figure the last number
            if(count>0){
                result.append(count);
                result.append(s.charAt(s.length()-1));
            }
            s = result.toString();
        }
        return s;
    }
}
