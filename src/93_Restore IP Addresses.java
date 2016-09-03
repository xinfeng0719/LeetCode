public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if(s==null||s.length()<4||s.length()>12) return result;
        StringBuilder sb = new StringBuilder();
        dfs(s,sb,result,0,0);
        return result;
    }
    public void dfs(String s,StringBuilder sb ,List<String> result, int step,int index){
        if(index==s.length()&&step==3){
            result.add(sb.toString());
            return;
        }
        if(step>3) return;//return when we exceed
        for(int i=index;i<s.length();i++){
            String t = s.substring(index,i+1);//string from index to i,but only index to index+3
            if(t.length()>3||(t.length()>1&&t.charAt(0)=='0')||Integer.valueOf(t)>255) break;
            int len = sb.length();
            sb.append(t);
            if(i+1!=s.length()){
                sb.append(".");
                dfs(s,sb,result,step+1,i+1);
            }else{
                dfs(s,sb,result,step,i+1);//i+1==s.length(),means in dfs, we will reach the end. 
            }
            
            sb.setLength(len);//backtracking
        }
    }
}
