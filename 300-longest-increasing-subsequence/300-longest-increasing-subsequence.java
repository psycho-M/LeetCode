class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] < nums[i]) max = Math.max(max, dp[j]);
            }
            dp[i] = 1 + max;
            // print(dp);
        }
        // return getLongestLIS(n - 1, dp, nums);
        int max = dp[0];
        for(int i : dp) max = Math.max(max, i);
        return max;
    }
    
    int getLongestLIS(int idx, int[] dp, int[] nums) {
        if(idx == 0) return 1;
        if(dp[idx] != -1) return dp[idx];
        
        int max = 0;
        for(int i = idx - 1; i >= 0; i--) {
            if(nums[i] < nums[idx]) max = Math.max(max, getLongestLIS(i, dp, nums));
        }
        
        System.out.println(max);
        
        return dp[idx] = 1 + max;
    }
    
    void print(int[] arr) {
        System.out.print("[");
        for(int n : arr) System.out.print(n + ",");
        System.out.println("]");
    }
}