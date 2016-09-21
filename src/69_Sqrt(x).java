public class Solution {
    public int mySqrt(int x) {
        //corner case
        if(x<0) return -1;
        else if(x==1||x==0) return x;
        //general case for x>1, the case is find the first number which fits t*t<=x,in order to decrease case
        //first time submit error tips:Don't every use mid*mid, since it could be interger overflow, compare mid with x/mid
        int start=0,end=x-1;
        while(start<end-1){
            int mid=start+(end-start)/2;
            if(mid>x/mid){
                end=mid-1;
            }else if(mid<x/mid){
                start=mid;
            }else{
                return mid;
            }
        }
        return (end*end)>x?start:end;
    }
}
