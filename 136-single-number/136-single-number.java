class Solution {
    public int singleNumber(int[] nums) {
        // HashSet Soln.
//         if(nums.length == 1) return nums[0];
        
//         Set<Integer> set = new HashSet<>();
//         for(int n : nums) {
//             if(set.contains(n)) set.remove(n);
//             else set.add(n);
//         }
        
//         Integer[] res = set.toArray(new Integer[1]);
//         return res[0];
        
        int res = 0;
        for(int n : nums) res ^= n;
        return res;
        
    }
}