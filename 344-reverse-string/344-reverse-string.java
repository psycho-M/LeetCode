class Solution {
    public void reverseString(char[] s) {
        // reverse(s, 0, s.length - 1);
        if(s.length == 1) return;
        int i = 0, j = s.length - 1;
        while(i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
    
    public void reverse(char[] s, int left, int right) {
        if(left >= right) return;
        char temp = s[left];
        s[left++] = s[right];
        s[right--] = temp;
        reverse(s, left, right);
    }
    
    
}