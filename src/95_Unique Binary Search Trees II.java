//there will be two methods: DP or Recursive
//In DP, we can reuse previous result, but in Recursive, we need to a lot duplicate copy
//only display recursive method, will update DP after figure it out.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        else{
            int[] dp = new int[n+1];
            dp[0]=1;
            dp[1]=1;
            for(int i=2;i<=n;i++){
                for(int j=1;j<=i;j++){
                    dp[i]+=dp[j-1]*dp[i-j];
                }
            }
            TreeNode[] resarr = recursion(1,n,dp);
            List<TreeNode> res = new ArrayList<>();
            for(TreeNode node:resarr){
                res.add(node);
            }
            return res;
        }
    }
    public TreeNode[] recursion(int s,int e,int[] dp){
        TreeNode[] roots = null;
        int curlen = 0;
        if(s>e){
            roots = new TreeNode[1];
            roots[0]=null;
            return roots;
        }
        roots = new TreeNode[dp[e-s+1]];
        for(int i=s;i<=e;i++){
            TreeNode[] lefts = recursion(s,i-1,dp);
            TreeNode[] rights = recursion(i+1,e,dp);
            for(TreeNode left:lefts){
                for(TreeNode right:rights){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    roots[curlen++]=root;
                }
            }
        }
        return roots;
    }
}
