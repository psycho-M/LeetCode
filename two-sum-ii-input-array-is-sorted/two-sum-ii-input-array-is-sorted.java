class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 2) {
            int[] ans = {0 + 1, 1 + 1};
            return ans;
        }
        
//         HashMap<Integer, Integer> map = new HashMap<>();
        
        
//         for(int i = 0; i < nums.length; i++) {
//             // System.out.println(i);
//             if(map.containsKey(target - nums[i])) {
//                 // System.out.println
//                 int[] ans = {map.get(target-nums[i]) + 1, i + 1};
//                 return ans;
//             }
//             map.put(nums[i], i);
//         }
        
        int l = 0, r = nums.length - 1;
        
        while(l < r) {
            if(nums[l] + nums[r] == target) {
                int[] ans = {l + 1, r + 1};
                return ans;
            } else if(nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        
        return new int[2];
    }
}