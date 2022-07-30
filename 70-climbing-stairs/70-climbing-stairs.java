class Solution {
    public int climbStairs(int n) {
        // int[] dp = new int[n + 1];
        // dp[0] = 0;
        // dp[1] = 1;
        // return findWays(n, dp);
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    int findWays(int n, int[] dp) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        int left = dp[n - 1] > 0 ? dp[n - 1] : findWays(n - 1, dp);
        int right = dp[n - 2] > 0 ? dp[n - 2] : findWays(n - 2, dp);
        dp[n] = left + right;
        return dp[n];
    }
}