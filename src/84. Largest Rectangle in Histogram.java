public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);//mark the start point
        int maxRec = 0;
        for(int i=0;i<heights.length;i++){
            while(stack.peek()!=-1 && heights[peek()]>=heights[i]){
                int height = heights[stack.pop()];
                maxRec = Math.max(maxRec,height*(i-stack.peek()-1));//stack.peek() is not part of the rectangle,so minus -1
            }
            stack.push(i);
            
        }

        
        int lastIndex = stack.peek();
        while(stack.peek() != -1){
            int height = heights[stack.pop()];
            maxRec = Math.max(maxRec, height * (lastIndex-stack.peek()));
        }
        return maxRec;
    }
}
