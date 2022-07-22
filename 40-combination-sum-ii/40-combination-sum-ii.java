class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        checkCombinations(0, new ArrayList<Integer>(), target, candidates, res);
        return res;
    }
    
    public void checkCombinations(int idx, List<Integer> curr, int target, int[] cand,
                                  List<List<Integer>> res) {
        if(idx == cand.length) {
            if(target == 0) res.add(new ArrayList<>(curr));        
            return;
        }
        
        if(cand[idx] <= target) {
            curr.add(cand[idx]);
            checkCombinations(idx + 1, curr, target - cand[idx], cand, res);
            curr.remove(curr.size() - 1);
        }
        while(idx + 1 < cand.length && cand[idx] == cand[idx + 1]) idx++;
        checkCombinations(idx + 1, curr, target, cand, res);
    }
}