//first part ,return all possible palindrome partitioning of s
//still can use DP for convenience
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        boolean[][] dp = new boolean[s.length()][s.length()];//dp[i][j] denote from substring from i to j is a palindrome or not
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j)&&((i-j<=2)||dp[j+1][i-1])){
                    //determine aXa(aXXa) is palindrome or not
                    //2 case, aXa or aXXa, so here we use or logic
                    dp[j][i]=true;
                }
            }
        }
        add(result,new ArrayList<String>(),dp,s,0);
        return result;
        
    }
    public void add(List<List<String>> result, List<String> path,boolean[][] dp,String s, int pos){
        if(pos==s.length()){
            result.add(new ArrayList<String>(path));//after position is at s.length()-1, means we find the case
            return;
        }
        for(int i=pos;i<s.length();i++){
            if(dp[pos][i]){
                path.add(s.substring(pos,i+1));
                add(result,path,dp,s,i+1);
                path.remove(path.size()-1);
            }
        }
    }
}

//second part, return the minimum cuts needed for a palindrome partitioning
//a good 2-D DP problem example
public class Solution {
    public int minCut(String s) {
        int[][] dp = new int[s.length()][s.length()];
        //boolean[][] dp = new boolean[s.length()][s.length()];
        //initialize dp
        int[] cut = new int[s.length()];
        for(int i=0;i<s.length();i++){
            cut[i] = Integer.MAX_VALUE;//cut[i] shows minimum cuts from 0 to index i;we iterate from 0-0, 0-1,0-2..until 0-n
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j)&&(i-j<=2||dp[j+1][i-1]==1)){
                    //only when we find that from j to i is palidrome, we calculate
                    dp[j][i] = 1;
                    if(j==0){
                        cut[i]=0;
                    }else{
                        cut[i]=Math.min(cut[i],1+cut[j-1]);//*, compare and use the minimum value
                    }
                }
            }
        }
        return cut[s.length()-1];
        
    }
}

