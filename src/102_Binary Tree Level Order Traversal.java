/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //bfs
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<TreeNode> map = new LinkedList<TreeNode>();
        map.offer(root);
        while(!map.isEmpty()){
            List<Integer> tmp = new ArrayList<Integer>();
            int size = map.size();
            for(int i=0;i<size;i++){
                TreeNode q = map.poll();
                if(q.left!=null) map.offer(q.left);
                if(q.right!=null) map.offer(q.right);
                tmp.add(q.val);
            }
            result.add(tmp);
        }
        return result;
    }
}

//dfs faster then bfs, though with O(N), but using queue is slower
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;      
    }
    public void helper(TreeNode root, int depth, List<List<Integer>> result) {
        if(root == null) return;
        helper(root.left, depth+1, result);
        while(result.size() <= depth) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        helper(root.right, depth+1, result);
    }
}

//further in DFS, as there is no need that we execute the dfs in-order, we can replace while loop by an if
//there will not any faster, but makes the code short
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;      
    }
    public void helper(TreeNode root, int depth, List<List<Integer>> result) {
        if(root==null) return;
        if(result.size()<=depth){
            result.add(new ArrayList<Integer>());
        }
        result.get(depth).add(root.val);
        helper(root.left, depth+1, result);
        helper(root.right, depth+1, result);
    }
}
