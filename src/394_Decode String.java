public class Solution {
    public String decodeString(String s) {
    Stack<String> stack = new Stack<String>();
    int k = 0;
    for(char c : s.toCharArray()){
        if(Character.isDigit(c)){
            k = k * 10 + c - '0';
        }else if(c == ']'){
            StringBuilder sb = new StringBuilder();
            while(!stack.peek().equals("[")){
                //if(stack.isEmpty()) always valid
                sb.insert(0, stack.pop());
            }
            //pop "["
            stack.pop();
            int num = Integer.parseInt(stack.pop());
               
            String repeat = sb.toString();
            sb.setLength(0);
            for(int i = 0; i < num; i++){
                sb.append(repeat);
            }
            //insert it back to stack
            stack.push(sb.toString());
        }else if(c == '['){
            stack.push(k+"");//push a string rather a int
            stack.push("[");
            k = 0;
        }else{
            stack.push(c+"");
        }
    }
        
    //concatenate elements in stack to a single String
    StringBuilder result = new StringBuilder();
    while(!stack.isEmpty()){
        result.insert(0, stack.pop());
    }
    return result.toString();
    }
}
