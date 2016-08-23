//depend on the BST's definition, the mid value shall be put in the root, then we can recursively create the TreeNode
//and put them in the left or right
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    public TreeNode sortedArrayToBST(int[] nums,int low,int high){
        TreeNode head = null;
        if(low==high){
            head = new TreeNode(nums[low]);
        }
        else if(low<high){
            int mid=low+(high-low)/2;
            head = new TreeNode(nums[mid]);
            head.left = sortedArrayToBST(nums,low,mid-1);
            head.right=sortedArrayToBST(nums,mid+1,high);
        }
        return head;
    }
}

//then think of the further method for minimize the logic
//first, remove the case if start=end. we extend the high value from nums.length-1 to nums.length, since they are int, then it is done
//second, let's think of the influence as we extend the high value.we shall also extend the left side's high value from mid-1 to mid.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return sortedArrayToBST(nums,0,nums.length); 
    }
    public TreeNode sortedArrayToBST(int[] nums,int low,int high){
        TreeNode head = null;
        if(low<high){
            int mid=low+(high-low)/2;
            head = new TreeNode(nums[mid]);
            head.left = sortedArrayToBST(nums,low,mid);
            head.right=sortedArrayToBST(nums,mid+1,high);
        }
        return head;
    }
}
