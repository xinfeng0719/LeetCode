public class Solution {
    TreeNode root = null;
    boolean flag = false;
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //nums[i]-nums[j]<=t while i-j<=k
        //when we iterate the nums, there will be two parts, 0-k, k+1->end, for 0-k, while nums[i]-nums[j] exist then return true;
        //while in k+1->end,we shall ignore the nums[0->k] and only care about the case from i->k+i
        //following the tips about BST, we can build a binary tree which maintain k nodes
        //every time we add one node to the BST, we will determine whether or not nums[i]-nums[j]<=t and update in the flag
        //during the loop, once flag is set to true, we will return.(in the case, we don't need to reset flag)
        for(int i=0;i<nums.length;i++){
            if(i>k){
                //remove nums[i-k-1] in our list
                root=delete(root,nums[i-k-1]);
            }
            //after remove, we can begin determine process and update in the flag
            root = insert(root,nums[i],t);
            if(flag) return true;
        }
        return false;
    }
    //we need two TreeNode function, 1 remove 2 insert
    public TreeNode insert(TreeNode root,int num,int t){
        //first number
        if(root==null){
            TreeNode curNode = new TreeNode(num);
            return curNode;
        }
        if(Math.abs((long)(root.val-num))<=t){//from test case, [-1,2147482647],k=1,t=2147483647,we shall consider extream case
            flag = true;
            return root;
        }
        if(root.val<num){
            root.right = insert(root.right,num,t);
        }else if(root.val>num){
            root.left = insert(root.left,num,t);
        }
        return root;
    }
    public TreeNode delete(TreeNode root,int num){
        if(root==null) return null;
        if(root.val<num){
            root.right = delete(root.right,num);
        }else if(root.val>num){
            root.left = delete(root.left,num);
        }else{
            if(root.left==null||root.right==null){
                return root.left==null?root.right:root.left;
            }else{
                //root.left and root.right are both not none
                //we shall find the minimum value in root's right subtree, and replace root by that value
                //after that we shall delete the minimum value that we used in root in root's right tree
                root.val = findMin(root.right).val;
                root.right = delete(root.right,root.val);
            }
        }
        return root;
    }
    public TreeNode findMin(TreeNode root){
        if(root==null) return null;
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
}
