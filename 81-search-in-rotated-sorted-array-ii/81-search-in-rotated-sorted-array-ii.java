class Solution {
    public boolean search(int[] nums, int t) {
        if(nums.length == 1) return nums[0] == t;
        int l = 0, r = nums.length - 1, m;
        while(l <= r) {
            m = (l + r) / 2;
            if(nums[m] == t) return true;
            if(nums[l] < nums[m]) {
                if(t < nums[l] || t > nums[m]) l = m + 1;
                else r = m - 1;
            } else if(nums[l] > nums[m]) {
                if(t < nums[m] || t > nums[r]) r = m - 1;
                else l = m + 1;
            } else l++;
        }
        return false;
        
        
        
        
        // if(nums.length == 1) return nums[0] == target;
        // Arrays.sort(nums);
        // int l = 0, r = nums.length - 1, m;
        // while(l <= r) {
        //     m = (l + r) /  2;
        //     if(nums[m] == target) return true;
        //     else if(nums[m] < target) l = m + 1;
        //     else r = m - 1;
        // }
        // return false;
        
    }
}