class Solution {
    public boolean canConstruct(String r, String m) {
        int[] alphR = new int[26];
        int[] alphM = new int[26];
        for(char c : m.toCharArray()) alphM[c - 'a']++;
        for(char c : r.toCharArray()) alphR[c - 'a']++;
        
        for(int i = 0; i < 26; i++) {
            if(alphM[i] < alphR[i]) return false;
        }
        
        return true;
    }
}