class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 1) return nums[0] == 1 ? 1 : 0;
        int i = 0, start = 0, max = 0;
        while(i < nums.length) {
            if(nums[i] == 0) {
                // System.out.println(nums[i]);
                max = Math.max(max, i - start);
                // System.out.println(max);
                while(i < nums.length && nums[i] == 0) i++;
                
                if(i == nums.length) {
                    return max;
                }
                
                start = i;
            }   
            i++;
        }
        
        return Math.max(max, i - start);
    }
}