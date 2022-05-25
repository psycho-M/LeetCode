class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int carry = 0, n1 = num1.length() - 1, n2 = num2.length() - 1, zeroes = 0;
        StringBuilder res = new StringBuilder(""), currProd;
        for(int i = n1; i >= 0; i--) {
            int c = num1.charAt(i) - '0';
            carry = 0;
            currProd = new StringBuilder("");
            for(int k = 0; k < zeroes; k++) currProd.append('0');
            for(int j = n2; j >= 0; j--) {
                int mult = num2.charAt(j) - '0';
                int prod = mult * c + carry;
                currProd.append(prod % 10);
                // System.out.println(currProd);
                carry = prod / 10;
            }
            if(carry > 0) currProd.append(carry);
            // System.out.println(currProd);
            res = add(res, currProd.reverse());
            // System.out.println(res);
            zeroes++;
        }
        
        return res.toString();
    }
    
    StringBuilder add(StringBuilder s1, StringBuilder s2) {
        StringBuilder sb = new StringBuilder("");
        int i = s1.length() - 1, j = s2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0) {
            int l = i >= 0 ? s1.charAt(i) - '0' : 0;
            int r = j >= 0 ? s2.charAt(j) - '0' : 0;
            sb.append((l + r + carry) % 10);
            carry = (l + r + carry) / 10;
            i--;
            j--;
        }
        if(carry > 0) sb.append(carry);
        return sb.reverse();
    }
}