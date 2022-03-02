class Solution {
    public boolean isSubsequence(String s, String t) {
        int tLen = t.length(), sLen = s.length();
        
        if(tLen == 0 && sLen == 0 || sLen == 0) return true;

        if(sLen > tLen || tLen == 0) return false;
        
        int[] alph = new int[26];
        char[] sChar = s.toCharArray();
        for(char c : sChar) alph[c - 'a']++;
        
        int count = s.length();
        int i = 0;
        for(char c : t.toCharArray()) {
            if(i < sLen && c == sChar[i] && sChar[i] > 0) {
                alph[c - 'a']--;
                i++;
            }
        }
        
        for(int n : alph)
            if(n > 0) return false;
        
        return true;
    }
}