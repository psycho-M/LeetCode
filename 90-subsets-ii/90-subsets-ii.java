class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        subSets(0, new ArrayList<>(), arr, res);
        return res;     
    }
    
     public void subSets(int idx, List<Integer> curr, int[] num, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        
        for(int i = idx; i < num.length; i++) {
            if(i > idx && num[i] == num[i - 1]) continue;
            curr.add(num[i]);
            subSets(i + 1, curr, num, res);
            curr.remove(curr.size() - 1);
        }
     }
}