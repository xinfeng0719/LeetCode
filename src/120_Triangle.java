public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] sum = new int[triangle.size()];
        sum[0]=triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<triangle.size();i++){
            List<Integer> row = triangle.get(i);
            for(int j=i;j>=0;j--){
                int val=row.get(j);
                if(j==i){
                    sum[j]=val+sum[j-1];
                }else if(j==0){
                    sum[0]=val+sum[0];
                }else{
                    sum[j]=val+Math.min(sum[j],sum[j-1]);
                }
            }
        }
        for(int num:sum){
            min = Math.min(min,num);
        }
        return min;
    }
}
