class Solution {
    public int strStr(String haystack, String needle) {
        
        /*
            A brute force appoach.
            We keep checking the pattern of needle in haystack everytime we find a character
            in haystack is equal to the first character of needle.
            
            Once we find the pattern, we return the index where we started comparing the two.
            if it doesn't find the pattern, we return -1;
        */
        
        int hayLen = haystack.length(), nLen = needle.length();
        
        if(hayLen == 0 && nLen == 0 || nLen == 0) return 0;
        
        if(hayLen == 0) return -1;
        
        // inbuilt methods 
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