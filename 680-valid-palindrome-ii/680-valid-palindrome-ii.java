class Solution {
    public boolean validPalindrome(String s) {
        // StringBuilder res = new StringBuilder(s);
        int i = 0, j = s.length() - 1;
        while(i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        String l = s.substring(0, i) + s.substring(i + 1);
        String r = s.substring(0, j) + s.substring(j + 1);
        return isValidPalindrome(l) || isValidPalindrome(r);
    }
    
    boolean isValidPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}