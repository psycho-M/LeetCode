class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 1) return nums[0] >= target ? 1 : 0;
        int min = nums.length + 1, sum = 0, l = 0, r = 0;
        while(r < nums.length) {
            if(nums[r] >= target) return 1;
            if(sum >= target) {
                min = Math.min(min, r - l);
                sum -= nums[l];
                l++;
                // System.out.println("sum = " + sum + " min = " + min + " l = " + l + " r = " + r);
                while(sum >= target) {
                    sum -= nums[l];
                    l++;
                    
                    if(sum >= target) min = Math.min(min, r - l); 
                    // System.out.println("sum = " + sum + " min = " + min + " l = " + l + " r = " + r);
                }
                
            } else {
                sum += nums[r];
                r++;
                // System.out.println(sum);
                // r++;
            }
        }
        
        while(sum >= target) {
            min = Math.min(min, r - l);
            sum -= nums[l];
            l++;
            // System.out.println("sum = " + sum + " min = " + min + " l = " + l + " r = " + r);
        }
        
        
        
        return min == nums.length + 1 ? 0 : min;
    }
}