public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        String left="([{";
        String right=")]}";
        for(char c:s.toCharArray()){
            if(left.indexOf(c)>-1){
                stack.push(c);
            }else if(stack.empty()||left.indexOf(stack.pop())!=right.indexOf(c)){
                return false;
            }
        }
        return stack.empty();
    }
}
