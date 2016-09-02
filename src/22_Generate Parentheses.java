public class Solution {
    public List<String> generateParenthesis(int n) {
        //left parenthesis shall be used before right parenthesis, so if we use one "(", we shall put a ")"
        List<String> result = new ArrayList<String>();
        String temp="";
        generate(n,n,result,temp);
        return result;
    }
    //left/right means how many left/right parenthesis left, if right = 0, then means we reach the end
    //if left>right, we shall return since right parenthesis can't be put before left parenthesis
    public void generate(int left,int right,List<String> result,String cur){
        if(right==0){
            result.add(cur);
        }
        if(left>right) return;
        if(left>0) generate(left-1,right,result,cur+"(");
        if(right>left) generate(left,right-1,result,cur+")");
        return;
    }
}
