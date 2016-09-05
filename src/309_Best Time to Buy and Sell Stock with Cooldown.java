//maintain two int array, when we at prices[i], the best price here has two condition:1.I sell here 2.I am in cooldown here
//then what we needed is to build these two array
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1) return 0;
        int[] cooldown = new int[prices.length];
        int[] sell = new int[prices.length];
        sell[0]=0;
        sell[1]=prices[1]-prices[0];
        cooldown[0]=0;
        cooldown[1]=0;
        int max = Math.max(sell[1],cooldown[1]);
        for(int i=2;i<prices.length;i++){
            sell[i]=Math.max(sell[i-1]+prices[i]-prices[i-1],cooldown[i-2]+prices[i]-prices[i-1]);
            cooldown[i]=Math.max(sell[i-1],cooldown[i-1]);
            max = Math.max(sell[i],cooldown[i]);
        }
        return max;
        
    }
}
