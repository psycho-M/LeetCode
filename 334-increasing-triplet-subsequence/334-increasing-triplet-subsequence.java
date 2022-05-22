class Solution {
    public boolean increasingTriplet(int[] nums) {
        // for(int i = 0; i < nums.length - 2; i++) {
        //     for(int j = i + 1; j < nums.length - 1; j++) {
        //         for(int k = j + 1; k < nums.length; k++) {
        //             if(nums[i] < nums[j] && nums[j] < nums[k]) return true;
        //         }
        //     }
        // }
        // return false;
        
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        
        for(int n : nums) {
            if(n <= small) small = n;
            else if(n <= big) big = n;
            else return true;
        }
        
        return false;
    }
}