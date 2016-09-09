public class Solution {
    public int nthUglyNumber(int n) {
        if(n==0||n==1) return n;
        int p2=0;
        int p3=0;
        int p5=0;
        int[] result = new int[n];
        result[0]=1;
        int i=1,min=0;
        while(i<n){
            min = Math.min(result[p2]*2,Math.min(result[p3]*3,result[p5]*5));
            if(min==result[p2]*2){
                p2++;
            }
            if(min==result[p3]*3){
                p3++;
            }
            if(min==result[p5]*5){
                p5++;
            }
            result[i]=min;
            i++;
        }
        return result[n-1];
    }
}
