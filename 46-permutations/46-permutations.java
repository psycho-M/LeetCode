class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // Set<Integer> visited = new HashSet<>();
        permutations(new ArrayList<>(), nums, res);
        return res;
    }
    
    public void permutations(List<Integer> curr, int[] nums, List<List<Integer>> res) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!(nums[i] == 11)) {
                int currNum = nums[i];
                curr.add(nums[i]);
                nums[i] = 11;
                permutations(curr, nums, res);
                nums[i] = currNum;
                curr.remove(curr.size() - 1);
            }
        }
    }
}