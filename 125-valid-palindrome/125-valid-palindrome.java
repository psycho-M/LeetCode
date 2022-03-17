class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("\\p{Punct}", "").replaceAll(" ", "").toLowerCase();
        StringBuffer res = new StringBuffer(s);
        res = res.reverse();
        return res.toString().equals(s);
    }
}