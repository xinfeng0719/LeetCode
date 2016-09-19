public class Solution {
    public int lastRemaining(int n) {
        if(n==1) return 1;
        return 2*remain(n/2);
    }
    public int remain(int n){
        if(n==1) return 1;
        if(n%2==0) return 2*lastRemaining(n/2)-1;
        return 2*lastRemaining(n/2);
    }
}
