class Solution {
    public String reverseWords(String s) {
        s.trim();
        String[] str = s.split(" ");
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < str.length; i++) {
            if(str[i].isBlank()) continue;
            
            res.append(new StringBuffer(str[i]).reverse());
            res.append(" ");
            
        }
        
        return res.toString().trim();
    }
}