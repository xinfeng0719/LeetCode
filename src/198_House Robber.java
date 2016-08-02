//when robber goes by every house, he has two choice, rob it or skip it.
//if he want to rob it, it means he didn't rob the previous house.
//in that case, we have two parameter to maintain, robprev means the robber robbing the previous house, leaveprev means the robber didn't rob the previous one.
//leveprev means we didn't rob this one, we could rob the previous one or we don't even rob the previous one, so we choose the higher value of robprev and leaveprev
//and then update these two value for the next rob case.
//at last, compare the robprev and leaveprev then we would have the correct answer.
public class Solution {
    public int rob(int[] nums) {
        int temp;
        int robprev=0,leaveprev=0;
        for(int i:nums){
            temp=robprev>leaveprev?robprev:leaveprev;
            robprev=leaveprev+i;
            leaveprev=temp;
        }
        return robprev>leaveprev?robprev:leaveprev;
    }
}
