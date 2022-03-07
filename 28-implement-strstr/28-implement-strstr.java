class Solution {
    public int strStr(String haystack, String needle) {
        int hayLen = haystack.length(), nLen = needle.length();
        
        if(hayLen == 0 && nLen == 0 || nLen == 0) return 0;
        
        if(hayLen == 0) return -1;
        
        // inbuilt methods 
        // int i = 0;
        // while(i <= hayLen - nLen) {
        //     if(haystack.charAt(i) == needle.charAt(0)) {
        //         if(haystack.substring(i, i + nLen).equals(needle)) return i;
        //     }
        //     i++;
        // }
        
        char[] hay = haystack.toCharArray();
        char[] ned = needle.toCharArray();
        int i = 0, j = 0, k = 0;
        while(i <= hayLen - nLen) {
            if(hay[i] == ned[0]) {
                j = 1;
                k = i + 1;
                while(j < nLen) {
                    if(hay[k] != ned[j]) break;
                    j++;
                    k++;
                }
                if(j == nLen) return i;
            }
            i++;
        }
        
        return -1;
    }
}