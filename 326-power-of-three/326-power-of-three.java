class Solution {
    public boolean isPowerOfThree(int n) {
        // if(n == 1) return true;
        // if(n == 0) return false;
        // double check = Math.log(n) / Math.log(3);
        // System.out.println(check);
        // return check == (int) check;
        // for(int i = 1; i <= n; i *= 3) {
        //     if(i == n) return true;
        // }
        // return false;
        String thirdBase = Integer.toString(n, 3);
        boolean res = thirdBase.matches("^10*$");
        return res;
    }
}