class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split(" ");
        int i = 0;
        
        StringBuffer res = new StringBuffer();
        i = 1;
        for(i = str.length - 1; i >= 0; i--) {
            if(str[i].isBlank()) continue;
            res.append(" ");
            res.append(str[i]);
        }
        
        return res.toString().trim();
    }
}