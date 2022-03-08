class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums.length == 2) return Math.min(nums[0], nums[1]);
        Arrays.sort(nums);
        int sum = 0;
        int i = 0;
        while(i < nums.length) {
            sum += Math.min(nums[i], nums[i + 1]);
            i += 2;
        }
        
        return sum;
    }
}