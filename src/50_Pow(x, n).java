public class Solution {
    public double myPow(double x, int n) {
        double result=1;
        for(int m=n;m!=0;m/=2){
            if(m%2!=0){
                result*=x;
            }
            x*=x;
        }
        return n>0?result:1/result;
    }
}
