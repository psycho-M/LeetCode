class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("\\p{Punct}", "").replaceAll(" ", "").toLowerCase();
        String rev = new StringBuffer(s).reverse().toString();
        return rev.toString().equals(s);
    }
}