class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        // int aSum = (n * (n + 1)) / 2;
        // int sum = 0;
        // for(int num : nums) sum += num;
        // return sum - aSum;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for(int key : map.keySet()) {
            if(map.get(key) > 1) return key;
        }
        return -1;
    }
}