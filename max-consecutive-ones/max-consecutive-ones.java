class Solution {
    
    /*
        A two pointer approach.
        we have 2 variables, max for the max consecutive ones and count for the current number of consecutive ones.
        We count the consecutive ones and check if the count is greater the max. 
        When we encounter 0, we reset the count to 0.
    */
    
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