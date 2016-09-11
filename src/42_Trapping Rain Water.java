public class Solution {
    public int trap(int[] height) {
        if(height.length==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int sum=0;
        for(int i=0;i<height.length;i++){
            if(stack.isEmpty()||height[stack.peek()]>=height[i]) stack.push(i);
            else{
                while(!stack.isEmpty()&&height[stack.peek()]<height[i]){
                    int index = stack.pop();
                    if(!stack.empty()){
                        int j=stack.peek();
                        sum+=(i-j-1)*(Math.min(height[i],height[j])-height[index]);
                    }
                }
                
                stack.push(i);
            }
        }
        return sum;
    }
}
