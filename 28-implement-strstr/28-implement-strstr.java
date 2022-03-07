class Solution {
    public int strStr(String haystack, String needle) {
        int hayLen = haystack.length(), nLen = needle.length();
        
        if(hayLen == 0 && nLen == 0 || nLen == 0) return 0;
        
        if(hayLen == 0) return -1;
        
        int i = 0;
        while(i <= hayLen - nLen) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                if(haystack.substring(i, i + nLen).equals(needle)) return i;
            }
            i++;
        }
        
        return -1;
    }
}