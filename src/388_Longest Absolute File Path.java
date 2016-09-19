    public int lengthLongestPath(String input) {
        String[] array = input.split("\n");
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int maxLen=0;
        for(String s:array){
            int lev = s.lastIndexOf("\t")+1;//number of /t
            while(lev+1<stack.size()) stack.pop();
            int curLen = stack.peek()+s.length()-lev+1;
            stack.push(curLen);
            if(s.contains(".")) maxLen = Math.max(maxLen,curLen-1);
        }
        return maxLen;
    }
}
