public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        int len = digits.length();
        if(len<1) return result;
        //initial result
        result.add("");
        for(int j=0;j<len;j++){
            char c = digits.charAt(j);
            //if(!dict.containsKey(c))) //not consider the case if we dial the wrong number
            //but we can continue if we treat 1 or other sign 
            if(!dict.containsKey(c)) continue;
            String cur = dict.get(c);
            //read the origin string, and append following possible character
            List<String> tmp = new ArrayList<String>();
            for(String s:result){
                for(int i=0;i<cur.length();i++){
                    tmp.add(s+cur.charAt(i));
                }
            }
            result = tmp;
        }
        return result;
    }
    private static Map<Character,String> dict;//key
    static{
        dict = new HashMap<>();
        dict.put('2',"abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
    }
}
