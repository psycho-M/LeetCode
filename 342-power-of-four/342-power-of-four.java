class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 1) return true;
        double temp = Math.log(n) / Math.log(4);
        return temp == (int)temp;
    }
}