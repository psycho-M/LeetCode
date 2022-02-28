class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 2) {
            // int[] ans = {0, 1};
            return new int[] {0, 1};
        }
        // int[] ans = new int[2];
        
        //Brute Force
        // for(int i = 0; i < len - 1; i++) {
        //     int curr = nums[i];
        //     for(int j = i + 1; j < len; j++) {
        //         if(curr + nums[j] == target) {
        //             int[] ans = {i, j};
        //             return ans;
        //         }
        //     }
        // }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
        for(int i = 0; i < nums.length; i++) {
            // System.out.println();
            if(map.containsKey(target - nums[i])) {
                // int[] ans = {i, map.get(target-nums[i])};
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        
        return new int[2];
    }
}