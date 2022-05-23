class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int n1 = num1.length(), n2 = num2.length(), curr = 0, i = n1 - 1, j = n2 - 1;
        StringBuilder res = new StringBuilder(n1 + n2);
        while(i >= 0 && j >= 0) {
            curr = carry + num1.charAt(i--) - '0' + num2.charAt(j--) - '0';
            carry = curr / 10;
            res.append(curr % 10);
        }
        
        while(i >= 0) {
            curr = carry + num1.charAt(i--) - '0';
            carry = curr / 10;
            res.append(curr % 10);
        }
        
        while(j >= 0) {
            curr = carry + num2.charAt(j--) - '0';
            carry = curr / 10;
            res.append(curr % 10);
        }
        
        if(carry > 0) res.append(carry);
        
        return res.reverse().toString();
    }
}