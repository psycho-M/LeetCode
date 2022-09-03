class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> res = new HashSet<>();
        
        for(int i = 1; i <= 9; i++) {
            getNs(String.valueOf(i), k, n - 1, res);
        }
        
        int[] ans = new int[res.size()];
        int i = 0;
        for(int num : res) ans[i++] = num;
        
        return ans;
    }
    
    private void getNs(String curr, int k, int n, Set<Integer> res) {
        if(n == 0) {
            res.add(Integer.parseInt(curr));
            return;
        }
        
        int num = curr.charAt(curr.length() - 1) - '0';
        
        if(num + k <= 9) getNs(curr + (num + k), k, n - 1, res);
        
        if(num - k >= 0) getNs(curr + (num - k), k, n - 1, res);
    }
}