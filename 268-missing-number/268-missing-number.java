class Solution {
    public int missingNumber(int[] nums) {
        int[] map = new int[nums.length + 1];
        for(int n : nums) map[n]++;
        
        for(int i = 1; i < map.length; i++) {
            if(map[i] == 0) return i;
        }
        
        return 0;
    }
}