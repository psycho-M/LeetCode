class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split(" ");
        int i = 0, j = str.length - 1;
        while(i < j) {
            String temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;
        }
        
        StringBuffer res = new StringBuffer();
        i = 1;
        for(String st : str) {
            if(st.isBlank()) continue;
            res.append(" ");
            res.append(st);
        }
        
        return res.toString().trim();
    }
    
    void print(String[] str) {
        System.out.print("[");
        for(String s : str) {
            
        }
    }
}