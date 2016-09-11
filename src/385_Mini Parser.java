/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        NestedInteger result;
        Stack<NestedInteger> record = new Stack<NestedInteger>();
        //when we face a "[", we know push a new NestedInteger with List into stack
        //once we have a"]", we will pop out the newest, and read the top one, and add the list into the top one.
        //besides, we need a function read the integer
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='['){
                record.push(new NestedInteger());
                i++;
            }else if(s.charAt(i)==']'){
                NestedInteger prev = record.pop();
                if(!record.isEmpty()){
                    //still have parent
                    record.peek().add(prev);
                }else{
                    //last ], pop out all
                    record.push(prev);
                }
                i++;
            }else if(s.charAt(i)==','){
                i++;
                continue;
            }else{
                //read number
                int plus=1,total=0;
                if(s.charAt(i)=='-'){
                    plus=-1;
                    i++;
                }
                for(;i<s.length();i++){
                    int cur = s.charAt(i)-'0';
                    if(cur>9||cur<0) break;//break when it is not a number
                    total=total*10+cur;
                }
                //after break,reset the i, figure out the number
                total*=plus;
                NestedInteger cur = new NestedInteger(total);
                if(record.isEmpty()){
                    //just a integer case
                    record.push(cur);
                }else{
                    //List case
                    NestedInteger prev = record.peek();
                    //add more item into List
                    prev.add(cur);
                }
            }
        }
        return record.pop();
    }
}
