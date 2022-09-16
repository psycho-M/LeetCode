class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        // int[][] dp = new int[multipliers.length][multipliers.length];
        // getScores(0, nums.length - 1, 0, nums, multipliers, dp);
        
        int N = nums.length, M = multipliers.length;

        return helper(nums, multipliers, 0, N - 1, new Integer[M][M]);
    }
    
//     private int getScores(int i, int j, int[] nums, int[] multipliers) {
//         if(mIdx == multipliers.length) {
//             return 0;
//         }
        
//         if(dp[])
        
//         int currL = multipliers[mIdx] * nums[nI] + getScores(nI + 1, nJ, mIdx + 1, nums, multipliers);
//         int currR = multipliers[mIdx] * nums[nJ] + getScores(nI, nJ - 1, mIdx + 1, nums, multipliers);
        
//         return Math.max(currL, currR);
//     }
    
    private int helper(int[] nums, int[] multipliers, int i, int j, Integer[][] dp) {

        int N = nums.length, M = multipliers.length;
        int index = (i - 0) + (N - 1 - j);
        if (index == M) return 0;

        if (dp[i][j - (N - M)] != null) return dp[i][j - (N - M)];

        int res = Math.max(nums[i] * multipliers[index] + helper(nums, multipliers, i + 1, j, dp), 
                           nums[j] * multipliers[index] + helper(nums, multipliers, i, j - 1, dp));

        return dp[i][j - (N - M)] = res;
    }
}

// public int maximumScore(int[] nums, int[] multipliers) {
        
// 	int N = nums.length, M = multipliers.length;

// 	return helper(nums, multipliers, 0, N - 1, new Integer[M][M]);
// }

