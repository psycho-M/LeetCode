class Solution {
    public String getSmallestString(int n, int k) {
        if(n == 1) {
            return String.valueOf((char)(k + 'a' - 1));
        }
        char[] res = new char[n];
        Arrays.fill(res, 'a');
        k -= n;
        for(int i = n - 1; i >= 0; i--) {
            res[i] += Math.min(25, k);
            k -= Math.min(25, k);
            if(k <= 0) break;
        }
        return new String(res);
    }
}