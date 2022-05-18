class Solution {
    public int majorityElement(int[] nums) {
        //Brute force - hashmap
//         if(nums.length < 3) return nums[0];
        
//         HashMap<Integer, Integer> map = new HashMap<>();
        
//         for(int n : nums) {
//             map.put(n, map.getOrDefault(n, 0) + 1);
//         }
        
//         int max = Integer.MIN_VALUE;
        
//         for(int n : map.keySet()) {
//             if(map.get(n) > nums.length / 2) return n;
//         }
//         // System.out.println(map);
//         return max;
        
        // sorting
        // Arrays.sort(nums);
        // return nums[nums.length / 2];
        
        //Boyer-Moore Voting Algo
        int count = 0, curr = 0;
        for(int n : nums) {
            if(count == 0) curr = n;
            count += n == curr ? 1 : -1;
        }
        return curr;
    }
}