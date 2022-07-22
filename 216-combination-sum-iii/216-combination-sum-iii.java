class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        checkCombinations(1, new ArrayList<>(), n, k, res);
        return res;
    }
    
    public void checkCombinations(int toAdd, List<Integer> curr, int target, int step, 
                                    List<List<Integer>> res) {
        if(toAdd > 9 && step != 0) return;
        if(step == 0) {
            if(target == 0) res.add(new ArrayList<>(curr));
            return;
        }
        
        if(toAdd <= target) {
            curr.add(toAdd);
            checkCombinations(toAdd + 1, curr, target - toAdd, step - 1, res);
            curr.remove(curr.size() - 1);
        }
        
        checkCombinations(toAdd + 1, curr, target, step, res);
    }
}