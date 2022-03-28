class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, m;
        while(l <= r) {
            m = (l + r) /  2;
            if(nums[m] == target) return true;
            else if(nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        return false;
    }
}