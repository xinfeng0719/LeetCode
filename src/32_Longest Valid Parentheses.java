public class Solution {
    public int longestValidParentheses(String s) {
        int left =-1,max=0;
        //Stack<Integer> record = new Stack<Integer>();//record the left parentheses's position
        //Stack goes a T
        LinkedList<Integer> record = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') record.push(i);
            else{
                if(record.size()==0){
                    left=i;
                }else{
                    record.pop();
                    if(record.size()==0){
                        max = Math.max(max,i-left);
                    }else{
                        max = Math.max(max,i-record.peek());
                    }
                }
            }
        }
        return max;
    }
}
