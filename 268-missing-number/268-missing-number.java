class Solution {
    public int missingNumber(int[] nums) {
//         Arrays.sort(nums);
        
//         for(int i = 0; i < nums.length; i++) {
//             if(i != nums[i]) return i;
//         }
        
//         return nums.length;
        
//         int[] map = new int[nums.length + 1];
//         for(int n : nums) map[n]++;
        
//         for(int i = 1; i < map.length; i++) {
//             if(map[i] == 0) return i;
//         }
        
//         return 0;
        
        int n = nums.length, actualSum = (n * (n + 1)) / 2;
        int numSum = 0;
        for(int i : nums) numSum += i;
        return actualSum - numSum;
    }
}