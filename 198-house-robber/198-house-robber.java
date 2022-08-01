class Solution {
    /*
        DP problem.
        Same as max subsequence sum with no two adjacent elements in the subsequence.
        Subsequence logic of take and notTake.
        logic: dp[i] = Math.min(take, notTake);
        
    */
    public int rob(int[] nums) {
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, -1);
//         dp[0] = nums[0];
//         return getMaxRobbery(nums.length - 1, dp, nums);
        int n = nums.length;
        if(n == 1) return nums[0];
        
        int prev2 = 0, prev = nums[0];
        
        for(int i = 1; i < n; i++) {
            int take = nums[i] + (i - 2 < 0 ? 0 : prev2);
            int notTake = 0 + prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        
        return prev;
    }
    
    private int getMaxRobbery(int idx, int[] dp, int[] nums) {
        if(idx == 0) return dp[0];
        if(idx < 0) return 0;
        
        if(dp[idx] != -1) return dp[idx];
        
        int take = nums[idx] + getMaxRobbery(idx - 2, dp, nums);
        int notTake = 0 + getMaxRobbery(idx - 1, dp, nums);
        
        dp[idx] = Math.max(take, notTake);
        return dp[idx];
    }
}