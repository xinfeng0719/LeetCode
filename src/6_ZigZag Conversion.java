/*
normally, the distance between two col is 2*(numRows-1)
but for extra col, as we goes zig-zag, the distance between two col is dist-2*i
0   6    12
1 5 7 11 13
2 4 8 10 14
3   9    15
*/
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int dist=2*(numRows-1);
        int len = s.length();
        char[] res= new char[len];
        int k=0;
        for(int i=0;i<numRows;i++){
            for(int j=i;j<len;j=j+dist){
                res[k++] = s.charAt(j);
                if(i>0&&i<numRows-1&&j+dist-2*i<len){
                    res[k++]=s.charAt(j+dist-2*i);//
                }
            }
        }
        return new String(res);
    }
}
