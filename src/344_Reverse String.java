public class Solution {
    public String reverseString(String s) {
        if(s==null||s.length()<=1) return s;
        char[] arr = s.toCharArray();
        int start=0,end=s.length()-1;
        while(start<end){
            char temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return new String(arr);
    }
}
