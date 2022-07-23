class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // Set<Integer> visited = new HashSet<>();
        permutations(0, new ArrayList<>(), nums, res);
        return res;
    }
    
    public void permutations(int step, List<Integer> curr, int[] nums, List<List<Integer>> res) {
        if(step == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!(nums[i] == 11)) {
                int currNum = nums[i];
                curr.add(nums[i]);
                nums[i] = 11;
                permutations(step + 1, curr, nums, res);
                nums[i] = currNum;
                curr.remove(curr.size() - 1);
            }
        }
    }
}