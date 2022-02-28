class Solution {
    public int searchInsert(int[] nums, int target) {
        /*
            We use binary search to search the target elememt.
            If found, we return that.
            Else we have found the element that is either the next greater or the next smaller
            number to the target value.
            We return the position where the target element can be inserted depending on
            whether the element at mid is greater or smaller than our target.
        */
        
        int mid = 0, l = 0, h = nums.length - 1;
        while(l <= h) {
            mid = (h + l) / 2;
            if(target == nums[mid]) return mid;
            else if(target > nums[mid]) l = mid + 1;
            else h = mid - 1;
        }
        
        return target > nums[mid] ? mid + 1 : mid;
        
    }
}