//with at most one transaction No.121
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int max=0,start=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<start){
                start=prices[i];
            }else{
                int cur = prices[i]-start;
                max = Math.max(cur,max);
            }
        }
        return max;
    }
}
//with unlimited transaction, but limited in multiple transactions at the same time(sell the stock before buy again).No.122
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<2) return 0;
		int maxp = 0;
		for(int i=1;i<len;i++){
			if(prices[i]>prices[i-1]) maxp+=prices[i]-prices[i-1];
		}
		return maxp;        
    }
}

//with the limited 2 transactions, it could be 3 ,4, or 5 in the future. No.123
//using Dynamic Programming. Maintain 2 array represent two transaction. 
//After cal 2 transactions's array, we can continue cal 3 transaction depending previous result.
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int[] firsthalf = new int[prices.length];
        int[] secondhalf = new int[prices.length];
        int current=0,max=0;
        //cal first half first,from the first day to i
        for(int i=1;i<prices.length;i++){
            current=Math.max(0,current+prices[i]-prices[i-1]);
            max = Math.max(max,current);
            firsthalf[i]=max;
        }
        current=0;
        max=0;
        //cal second half, from j to last
        for(int j=prices.length-1;j>0;j--){
            current = Math.max(0,current+prices[j]-prices[j-1]);
            max = Math.max(current,max);
            secondhalf[j-1]=max;
        }
        
        max=0;
        for(int i=0;i<prices.length;i++){
            max = Math.max(firsthalf[i]+secondhalf[i],max);
        }
        
        return max;
    }
}
