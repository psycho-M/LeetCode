class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return getCombinations(target, nums, dp);
    }
    
    private int getCombinations(int target, int[] nums, int[] dp) {
        if(target == 0) return 1;
        if(dp[target] != -1) return dp[target];
        dp[target] = 0;
        for(int n : nums) {
            if(n <= target) dp[target] += getCombinations(target - n, nums, dp);
        }
        return dp[target];
    }
}