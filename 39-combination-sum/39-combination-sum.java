class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        checkCombination(0, new ArrayList<Integer>(), 0, candidates, target, res);
        return res;
    }
    
    public void checkCombination(int idx, List<Integer> curr, int sum, int[] cand, int target, 
                                    List<List<Integer>> res) {
        if(idx == cand.length || sum >= target) {
            if(sum == target) res.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(cand[idx]);
        checkCombination(idx, curr, sum + cand[idx], cand, target, res);
        curr.remove(curr.size() - 1);
        if(idx < cand.length - 1 && sum + cand[idx + 1] > target) return;
        checkCombination(idx + 1, curr, sum, cand, target, res);
    }
}