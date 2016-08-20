/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //two method, 1 use DFS, but reverse the whole List after DFS
 //or we can use BFS, but we shall use LinkedList as we need to use its addfirst method for adding List<Integer> in the index 0
public class Solution {
public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    travelTree(0, root, result);
    List<List<Integer>> reverseRst = new ArrayList<>();
    for (int i = 0; i < result.size(); i++) {
        reverseRst.add(result.get(result.size() - i - 1));
    }
    return reverseRst;
}

private void travelTree(int level, TreeNode root, List<List<Integer>> result) {
    if (root == null) return;
    if (result.size() <= level) result.add(new ArrayList<>());
    result.get(level).add(root.val);
    travelTree(level + 1, root.left, result);
    travelTree(level + 1, root.right, result);
}
}

//bfs
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       LinkedList<List<Integer>> lob = new LinkedList<List<Integer>>();
        if (root == null) return lob;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size=q.size();
            LinkedList<Integer> row = new LinkedList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode n=q.poll();
                row.add(n.val);
                if(n.left!=null){
                    q.offer(n.left);
                }
                if(n.right!=null){
                    q.offer(n.right);
                }
            }
            lob.addFirst(row);
        }
        //lob.addFirst(row);
        return lob;
    }
}
