class Solution {
    public boolean find132pattern(int[] nums) {
        // Brute force : TLE
        // int minI = Integer.MAX_VALUE;
        // for(int j = 0; j < nums.length - 1; j++) {
        //     minI = Math.min(minI, nums[j]);
        //     for(int k = j + 1; k < nums.length; k++) {
        //         if(minI < nums[k] && nums[k] < nums[j]) return true;
        //     }
        // }
        // return false;
        
        int n = nums.length, top = n, third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) return true;
            while (top < n && nums[i] > nums[top]) third = nums[top++];
            nums[--top] = nums[i];
        }
    
        return false;
    }
}