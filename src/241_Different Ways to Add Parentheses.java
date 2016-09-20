public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if(!input.contains("+")&&!input.contains("-")&&!input.contains("*")){
            result.add(Integer.valueOf(input));
            return result;
        }
        //for each sign, we generate 
        for(int i=0;i<input.length();i++){
            char cur = input.charAt(i);
            if(cur=='*'||cur=='+'||cur=='-'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(int leftVal:left){
                    for(int rightVal:right){
                        switch(cur){
                            case '+':result.add(leftVal+rightVal);break;
                            case '-':result.add(leftVal-rightVal);break;
                            case '*':result.add(leftVal*rightVal);break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
