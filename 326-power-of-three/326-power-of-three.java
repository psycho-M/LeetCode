class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        if(n == 0) return false;
        // double check = Math.log(n) / Math.log(3);
        // System.out.println(check);
        // return (check + 1) % 1 <= 2 * 1;
        long temp = 1;
        for(int i = 1; i <= 19; i++) {
            temp *= 3;
            if(temp == n) return true;
        }
        return false;
        // return false;
        // String thirdBase = Integer.toString(n, 3);
        // boolean res = thirdBase.matches("^10*$");
        // return res;
    }
}