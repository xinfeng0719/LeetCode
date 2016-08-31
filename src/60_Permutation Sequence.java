public class Solution {
    public String getPermutation(int n, int k) {
        int total = 1;
        int cur=1;
        boolean[] flag = new boolean[n+1];
        for(;cur<=n;cur++){
            total *=cur;
        }
        if(k>total) return "";
        int next = total/n;
        int level=n-1;
        String output  = "";
        
        while(level>0){
            //next shows how many cases that every digit have as head
            //total/next is the index of the digit
            //then determine the index from 0-9 by using a ArrayList
            int index = k/next;
            int extra = k%next;
            //extra!=0, like 3/2=1, but actually we shall use 2 in stead of 1
            if(extra==0){
                index-=1;
            }
            int count=0;
            for(int i=1;i<=n;i++){
                if(flag[i]==false) count++;
                if(count==index+1){
                    output+=i;
                    flag[i]=true;
                    break;
                }
            }
            //after one round, 
            k = k-index*next;
            next = next/level;
            level--;
        }
        for(int i=1;i<=n;i++){
            if(flag[i]==false){
                output+=i;
            }
        }
        return output;
    }
}
