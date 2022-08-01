class Solution {
    public int rob(int[] nums) {
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
}