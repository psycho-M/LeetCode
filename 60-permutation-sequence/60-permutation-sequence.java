class Solution {
    int k;
    String res = "";
    public String getPermutation(int n, int k) {
        this.k = k;
        int[] visited = new int[n + 1];
        getKthPermutation(new ArrayList<>(), n, visited);
        return res;
    }
    
    public void getKthPermutation(List<Integer> curr, int n, int[] visited) {
        if(curr.size() == n) {
            k--;
            if(k == 0) {
                for(int i : curr) res += "" + i;
            } 
            return;
        }
        
        for(int i = 1; i <= n; i++) {
            if(visited[i] == 1) continue;
            visited[i] = 1;
            curr.add(i);
            // System.out.println(curr);
            getKthPermutation(curr, n, visited);
            if(k == 0) return;
            curr.remove(curr.size() - 1);
            visited[i] = 0;
        }
        
        
        
    }
}