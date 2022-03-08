class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 1) return nums[0] == 1 ? 1 : 0;
        int i = 0, start = 0, max = 0, count = 0;
        while(i < nums.length) {
            if(nums[i] == 1) count++;
            else count = 0;
            
            if(count > max) max = count;
            
//             if(nums[i] == 0) {
//                 max = Math.max(max, i - start);
//                 while(i < nums.length && nums[i] == 0) i++;
                
//                 if(i == nums.length) {
//                     return max;
//                 }
                
//                 start = i;
//             }
            
            i++;
        }
        
        return max;
    }
}