class Solution {
    public String reverseVowels(String s) {
        char[] sChar = s.toCharArray();
        
        int l = 0, r = sChar.length - 1;
        
        while(l < r) {
            while(l < r && !isVowel(sChar[l])) l++;
            while(r > l && !isVowel(sChar[r])) r--;
            char temp = sChar[l];
            sChar[l] = sChar[r];
            sChar[r] = temp;
            l++;
            r--;
        }
        
        return new String(sChar);
    }
    
    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}