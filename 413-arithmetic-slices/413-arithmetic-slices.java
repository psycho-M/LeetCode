class Solution {
    /*
        In this problem we observe that a subarray, with a length of >= 3, will have
            (n * (n + 1)) / 2
        subarrays that satisfies the condition for arithmetic array given in the problem.
        where n = (j - i - 1),
        i = start index of subarray,
        j = end index of subarray
        
        Ex: [1,2,3,4,3,2,1,0]
        First subarray: i = 0, j = 3, n = 2, Ans = (2 * 3) / 2 = 3
        Second subarray: i = 3, j = 7, n = 3, Ans (3 * 4) / 2 = 6
        
        Final ans = 3 + 6 = 9
        
        I don't know DP yet, so idk what to call this approach.
    */
    
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