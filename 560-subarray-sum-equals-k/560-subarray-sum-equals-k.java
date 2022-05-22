class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 1) return nums[0] == k ? 1 : 0;
        int count = 0, sum = 0;
        //Brute force - works - very very slow
//         for(int i = 0; i < nums.length - 1; i++) {
            
//             // if(i == nums.length - 1) {
//             //     if(nums[i] == k) count++;
//             //     break;
//             // }
            
//             if(nums[i] == k) {
//                 count++;
//             }
            
//             sum = nums[i];
//             for(int j = i + 1; j < nums.length; j++) {
//                 sum += nums[j];
//                 if(sum == k) count++;
//             }
//         }
        
//         if(nums[nums.length - 1] == k) count++;
        
        //O(n) solution
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int n : nums) {
            sum += n;
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}