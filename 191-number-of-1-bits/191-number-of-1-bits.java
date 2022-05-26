public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // return Integer.bitCount(n);
        String binary = Integer.toBinaryString(n);
        int count = 0;
        for(char c : binary.toCharArray()) {
            if(c == '1') count++;
        }
        return count;
    }
}