public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> record = new Stack<String>();
        String[] pre = preorder.split(",");
        for(String cur:pre){
            if(cur.equals("#")){
                while(!record.isEmpty()&&record.peek().equals("#")){
                    record.pop();
                    if(record.isEmpty()) return false;
                    record.pop();
                }
                record.push(cur);
            }else{
                record.push(cur);
            }
        }
        String left=record.pop();
        return left.equals("#")&&record.isEmpty();
    }
}
