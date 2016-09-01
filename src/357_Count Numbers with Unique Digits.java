public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        //if n>10, then there would be zero since digit must be duplicate
        //if n=0, then it would 1? It depends on assumption, can be changed
        if(n==0) return 1;
        if(n==1) return 10;
        if(n>10) return 0;
        int current = 81;//for f(2) f(n)=f(n-1)*(11-n);depend on previous result, we have 11-n 
        int total=91;
        for(int i=3;i<=n;i++){
            current*=(11-i);
            total+=current;
        }
        return total;
    }
}
