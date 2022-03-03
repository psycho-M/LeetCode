class Solution {
    /*
        A two pointer problem.
        First we create an int array of length 26 (to store frequency of the letters), alph, and
        iterate over s char array to store the frequencies of the letters into alph.
        Now we use two pointers, one on the strting t, the other on the charArray of s.
        Then compare the letters at the current pointer positions of s and t.
        if same
            we check if the frequency of that letter is greater than zero in alph
            if yes
                we reduce the frequency of that and increase both pointers by one.
        Once we reach the end of string s
    */
    
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
            if(i < sLen && c == sChar[i]) {
                alph[c - 'a']--;
                i++;
            }
            
            if(i == sLen) break;
        }
        
        for(int n : alph)
            if(n > 0) return false;
        
        return true;
    }
}