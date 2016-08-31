//flip and add
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        for(int i=0;i<n;i++){
            //flip and move to the left
            for(int j=result.size()-1;j>=0;j--){
                result.add(result.get(j)+(1<<i));
            }
        }
        return result;
    }
}
