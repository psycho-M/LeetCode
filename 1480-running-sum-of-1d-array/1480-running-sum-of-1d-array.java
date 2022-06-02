class Solution {
    public int[] runningSum(int[] nums) {
        if(nums.length == 1) return nums;
        int[] rs = new int[nums.length];
        rs[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            rs[i] = nums[i] + rs[i - 1];
        }
        
        return rs;
    }
}