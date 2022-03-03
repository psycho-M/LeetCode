class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0;
        
        int count = 0, i, j;
        
        for(i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            for(j = i + 1; j < nums.length - 1; j++) {
                if(nums[j + 1] - nums[j] != diff) {
                    break;
                }
            }
            if(j - i > 1) {
                count += sumUptoN(j - i - 1);
            }
            
            i = j - 1;
        }
        
        return count;
    }
    
    public int sumUptoN(int n) {
        return (n * (n + 1)) / 2;
    }
}