class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        getSubsets(0, nums, curr, res);
        return res;
    }
    
    private void getSubsets(int idx, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        
        for(int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            getSubsets(i + 1, nums, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}