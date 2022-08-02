class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0]; 
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        for(int i = 1; i < n - 1; i++) {
            int prev = nums[i] + (i - 2 < 0 ? 0 : dp[i - 2]);
            int prev2 = 0 + dp[i - 1];
            dp[i] = Math.max(prev, prev2);
        }
        int max = dp[n - 2];
        Arrays.fill(dp, 0);
        dp[1] = nums[1];
        
        for(int i = 2; i < n; i++) {
            int prev = nums[i] + (i - 2 < 1 ? 0 : dp[i - 2]);
            int prev2 = 0 + dp[i - 1];
            dp[i] = Math.max(prev, prev2);
        }
        
        return Math.max(max, dp[n - 1]);
    }
}