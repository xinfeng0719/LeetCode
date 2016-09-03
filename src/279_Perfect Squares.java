public class Solution {
    public int numSquares(int n) {
        int[] s = new int[n+1];
        for(int i=0;i<n+1;i++){
            s[i]=Integer.MAX_VALUE;
        }
        //use dp 
        for(int i=1;i<n+1;i++){
            int sqrt = (int) Math.sqrt(i);//cal the squre root of int i
            if(i==sqrt*sqrt){
                //is i is a perfect number, then s[i]=1
                s[i]=1;
                continue;
            }
            for(int j=1;j<=sqrt;j++){
                //then we shall think the case that i is not a perfect number. i will be the addition of some perfect number
                //s[i]=s[i-j*j]+1;(sqrt+1)*(sqrt+1)>i,so we will end loop when j==sqrt
                //besides, we need the minimum,so one judgement is required
                if(s[i]>s[i-j*j]+1){
                    s[i]=s[i-j*j]+1;
                }
            }

        }
        
        return s[n];
    }
}
