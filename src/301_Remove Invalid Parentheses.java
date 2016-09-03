public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        int leftP=0,rightP=0;
        for(int i=0;i<s.length();i++){
            //after that, we know how many left or right parenthesis that is exceeded
            if(s.charAt(i)=='('){
                leftP++;
            }else if(s.charAt(i)==')'){
                if(leftP>0) leftP--;
                else rightP++;
            }
        }
        dfs(result,s,0,leftP,rightP,sb,0);
        return new ArrayList<String>(result);
        
    }
    public void dfs(Set<String> result, String s, int i,int leftP,int rightP,StringBuilder sb,int flag){
        
        if(i==s.length()&&leftP==0&&rightP==0&&flag==0){
            result.add(sb.toString());
            return;
        }
        if(i==s.length()||leftP<0||rightP<0||flag<0) return;
        
        char c = s.charAt(i);
        int len = sb.length();
        if(c=='('){
            //if we deal with a '(', we can remove it, then leftP-- or we can append it to th StringBuilder
            //in addition,'(' shall come before ')', when we add a '(' to sb, we shall add 1 to flag, once we have
            // a ')', we can delete by 1. This flag can't be smaller than 0, when we add the string to List, this 
            //flag must be 0;
            dfs(result,s,i+1,leftP-1,rightP,sb,flag);
            dfs(result,s,i+1,leftP,rightP,sb.append(c),flag+1);
            //order is also important, if we did sb.append(c) first, before we do the not append case, we shall backtrack the length,code will be like
            //dfs(result,s,i+1,leftP,rightP,sb.append(c),flag+1);
            //sb.setLength(len);
            //dfs(result,s,i+1,leftP-1,rightP,sb,flag);
            //for clearness, not use it.
        }else if(c==')'){
            //similar to '(', delete it or keep it
            dfs(result,s,i+1,leftP,rightP-1,sb,flag);
            dfs(result,s,i+1,leftP,rightP,sb.append(c),flag-1);
        }else{
            dfs(result,s,i+1,leftP,rightP,sb.append(c),flag);
        }
        //backtrack*
        sb.setLength(len);
    }
}
