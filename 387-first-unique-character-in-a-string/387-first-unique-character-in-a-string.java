class Solution {
    public int firstUniqChar(String s) {
        int[] alph = new int[26];
        for(char c : s.toCharArray()) alph[c - 'a']++;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            if(alph[i] == 1) {
                min = Math.min(min, s.indexOf((char)(i + 'a')));
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}