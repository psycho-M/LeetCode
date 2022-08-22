class Solution {
    public boolean isPowerOfFour(int n) {
        // if(n == 1) return true;
        // double temp = Math.log(n) / Math.log(4);
        // return temp == (int)temp;
        
        if(n == 0) return false;
        if(n == 1) return true;
        
        return (n / 4.0) == (n>>2) ? isPowerOfFour(n>>2) : false;
    }
}