class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), teamMap = new HashMap<>();
        
        for(int i : nums) freq.put(i, freq.getOrDefault(i, 0) + 1);
        
        for(int i = 0; i < nums.length; i++) {
            if(freq.getOrDefault(nums[i], 0) <= 0) continue;
            else if(teamMap.getOrDefault(nums[i], 0) > 0) {
                freq.put(nums[i], freq.getOrDefault(nums[i], 0) - 1);
                teamMap.put(nums[i], teamMap.getOrDefault(nums[i], 0) - 1);
                teamMap.put(nums[i] + 1, teamMap.getOrDefault(nums[i] + 1, 0) + 1);
            } else if(freq.getOrDefault(nums[i], 0) > 0 && freq.getOrDefault(nums[i] + 1, 0) > 0 &&
                    freq.getOrDefault(nums[i] + 2, 0) > 0) {
                freq.put(nums[i], freq.getOrDefault(nums[i], 0) - 1);
                freq.put(nums[i] + 1, freq.getOrDefault(nums[i] + 1, 0) - 1);
                freq.put(nums[i] + 2, freq.getOrDefault(nums[i] + 2, 0) - 1);
                teamMap.put(nums[i] + 3, teamMap.getOrDefault(nums[i] + 3, 0) + 1);
            } else return false;
        }
        return true;
        
    }
}